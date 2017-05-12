package com.preag.pimailing.maildialog.run;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;

import com.preag.core.outlook.signature.OutlookSignature;
import com.preag.core.outlook.signature.OutlookSignatureService;
import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.pimailing.maildialog.MailDialogEvent;
import com.preag.pimailing.maildialog.MailDialogService;
import com.preag.pimailing.maildialog.MailDialogView;
import com.preag.pimailing.maildialog.previews.MailPreView;
import com.preag.pimailing.maildialog.recieverdialog.RecieverDialogView;

import helper.PopOverProducer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		MailDialogView mailDialogView = new MailDialogView();
		mailDialogView.setRecieverItems(FXCollections.observableList(createSomeUsers()));
		mailDialogView.setSignatureItems(FXCollections.observableList(createSignatures()));
		mailDialogView.setTemplateItems(createTemplates());
		mailDialogView.addEventHandler(MailDialogEvent.PREVIEW, evt -> openPreviewWindow(evt));
		mailDialogView.addEventHandler(MailDialogEvent.RECEIVER, evt -> openReceiverWindow(mailDialogView));
		mailDialogView.addEventHandler(MailDialogEvent.TEMPLATE, evt -> openTemplateWindow(mailDialogView));
		/////////////////////////////
		// FOR TESTING USING TESTFX//
		////////////////////////////
		// FXMLLoader view = new
		// FXMLLoader(Main.class.getResource("/com/preag/pimailing/maildialog/MailDialogView.fxml"));
		// view.setRoot(new MailDialogView());
		// view.load();
		stage = primaryStage;
		Scene scene = new Scene(mailDialogView);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void openTemplateWindow(MailDialogView mailDialogView) {
	}

	private void openPreviewWindow(MailDialogEvent evt) {
		MailDialogView mailDialogView = (MailDialogView) evt.getTarget();
		MailPreView mailPreView = new MailPreView();
		mailPreView.setSubject(mailDialogView.getSubject());
		mailPreView.setMessageBody(mailDialogView.getMessagebody());
		mailPreView.setTransmitter(mailDialogView.getSelectedTransmitter());
		mailPreView.setRecievers(MailDialogService.convertAttachmentToString(mailDialogView.getRecieverItems()));
		mailPreView.setAttachments(MailDialogService.convertAttachmentToString(mailDialogView.getAttachmentItems()));
		if (mailDialogView.isPersonalAddress()) {
			mailPreView.setPersonalAdress(
					"Sehr geehrte(r) Herr/Frau " + mailDialogView.getRecieverItems().get(0).getText());
		} else {
			mailPreView.setPersonalAdress("Sehr geehrte Damen und Herren");
		}

		PopOver popOver = PopOverProducer.getPopOver(mailDialogView.getPreviewButton());
		popOver.setContentNode(mailPreView);
		popOver.setArrowLocation(ArrowLocation.TOP_RIGHT);
		popOver.show(mailDialogView.getPreviewButton());
	}
	
	private void openReceiverWindow(MailDialogView mailDialogView){
		RecieverDialogView recieverDialogView = new RecieverDialogView();
		recieverDialogView.setRecieverItems(mailDialogView.getRecieverItems());
		Alert customContentDialog = Dialogs.okCustomContentDialog(recieverDialogView, "Empfänger Liste überprüfen",
				null, mailDialogView.getScene().getWindow(), null, "OK");
		customContentDialog.showAndWait();
	}

	private ObservableList<Template> createTemplates() {
		ObservableList<Template> templates = FXCollections.observableList(new ArrayList<>());
		for (int i = 0; i < 6; i++) {
			Template template = new Template();
			template.setCaption("Template" + i);
			template.setBody(
					"<html><style> p{margin:0px; padding:0px;} </style><p>{Briefanrede}</p><p>Sies haben sich für unser Neubauvorhaben in der Herrnstraße 45, Fürth interessiert. Inzwischen ist der Rohbau des 1. Bauabschnittes fertig gestellt.</p><p>Wir möchten Sie daher ganz herzlich zur Eröffnung der Musterwohnung einladen.</p><p>Am Freitag, den 21.03.2014, von 16:00 -19:00 Uhr, in der Herrnstraße 45, 90763 Fürth, EG.</p><p>Dabei können Sie sich von den Wohnung, Grundrissen und der Ausstattung einen noch besseren Eindruck verschaffen.</p><p>Wir freuen uns auf Ihren Besuch!</p></html>");
			templates.add(template);
		}
		return templates;
	}

	private List<Signature> createSignatures() {
		List<Signature> signatures = new ArrayList<>();
		try {
			List<OutlookSignature> outlookSignatures = OutlookSignatureService.findAll();
			for (OutlookSignature outlookSignature : outlookSignatures) {
				Signature signature = new Signature();
				signature.setSignatureHTML(outlookSignature.getSignatureHtml());
				List<File> files = new ArrayList<>();
				files.add(new File(outlookSignature.getLogoPath()));
				signature.setSignatureLogo(files);
				signature.setSignatureName(outlookSignature.getSignatureName());
				signatures.add(signature);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return signatures;
	}

	private List<Label> createSomeUsers() {
		List<User> users = new ArrayList<>();
		List<Label> usersLbl = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId((long) i);
			user.setEmail("email@yahoo.fr" + i);
			user.setNachName("Nachname" + i);
			user.setVorName("Vorname" + i);
			users.add(user);
			Label label = new Label();
			label.setText(user.getVorName() + "," + user.getNachName());
			label.setId(user.getId() + "");
			label.setUserData(user);
			usersLbl.add(label);
		}
		return usersLbl;
	}

}

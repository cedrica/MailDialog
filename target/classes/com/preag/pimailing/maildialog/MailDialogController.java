package com.preag.pimailing.maildialog;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;
import org.controlsfx.control.ToggleSwitch;

import com.preag.core.ui.advancedhtmleditor.AdvancedHtmlEditor;
import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.pimailing.maildialog.advancedtextfield.AdvancedTextFieldEvent;
import com.preag.pimailing.maildialog.advancedtextfield.AdvancedTextFieldView;
import com.preag.pimailing.maildialog.converter.SignatureConverter;
import com.preag.pimailing.maildialog.converter.TemplateConverter;
import com.preag.pimailing.maildialog.previews.MailPreView;
import com.preag.pimailing.maildialog.recieverdialog.RecieverDialogView;
import com.preag.pimailing.maildialog.run.Main;
import com.preag.pimailing.maildialog.run.Signature;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Callback;

public class MailDialogController implements Initializable {

	// ROOTNODE
	@FXML
	MailDialogView mailDialogView;
	// -------------------------------------------
	@FXML
	ComboBox cboTransmitter;
	@FXML
	AdvancedTextFieldView atfvRecievers;
	private RecieverDialogView recieverDialogView;
	@FXML
	TextField tfSubject;
	@FXML
	AdvancedTextFieldView atfvAttachments;
	@FXML
	ToggleSwitch tsPersonalAddress;
	@FXML
	ComboBox cboSelectedTemplate;
	@FXML
	AdvancedHtmlEditor aheMessageBody;
	@FXML
	ComboBox<Signature> cboSignature;

	@FXML
	VBox vbSendImage;
	MailPreView mailPreView;
	@FXML
	Button btnShowPreview;
	@FXML
	Button btnSaveTemplate;
	private String currentMessageBody = "";
	private String currentSignature = "";
	private PopOver popOver;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mailPreView = new MailPreView();
		popOver = new PopOver();
		recieverDialogView = new RecieverDialogView();
		registerBindings();
		registerListener();
		atfvRecievers.setMaxNumberOfItems(6);
		initCellFactory();
		initConverter();
		if (mailDialogView.isPersonalAddress()) {
			mailPreView.setPersonalAdress(
					"Sehr geehrte(r) Herr/Frau " + mailDialogView.getRecieverItems().get(0).getText()+";");
		} else {
			mailPreView.setPersonalAdress("Sehr geehrte Damen und Herren;");
		}
	}

	private void registerListener() {
		aheMessageBody.getWebView().focusedProperty().addListener((obs, oldVal, newVal) -> {
			if (!newVal) {

			}
		});
		atfvAttachments.addEventFilter(AdvancedTextFieldEvent.SPEAK_TO_MY_SELF, evt -> {
			evt.consume();
			ObservableList<String> newList = evt.getAttachments();
			mailPreView.setAttachments(FXCollections.observableList(new ArrayList<>()));// to
																						// clear
																						// the
																						// list
			mailPreView.setAttachments(newList);
		});

		// START: MailPreview Binding
		mailDialogView.subjectProperty().addListener((obs, oldVal, newVal) -> {
			mailPreView.setSubject(newVal);
		});

		mailDialogView.selectedTransmitterProperty().addListener((obs, oldVal, newVal) -> {
			mailPreView.setTransmitter(newVal);
		});
		mailDialogView.recieverItemsProperty().addListener((obs, oldVal, newVal) -> {
			mailPreView.setRecievers(MailDialogService.convertAttachmentToString(newVal));
		});
		mailDialogView.attachmentItemsProperty().addListener((obs, oldVal, newVal) -> {
			mailPreView.setAttachments(MailDialogService.convertAttachmentToString(newVal));
		});
		mailDialogView.personalAddressProperty().addListener((obs, oldVal, newVal) -> {
			mailPreView.setPersonalAdress(
					(newVal) ? "Sehr geehrte(r) Herr/Frau " + mailDialogView.getRecieverItems().get(0).getText()+";"
							: "Sehr geehrte Damen und Herren;");
		});

		mailDialogView.selectedTemplateProperty().addListener((obs, oldVal, newVal) -> {
			aheMessageBody.setHtmlText(newVal.getBody());
			mailPreView.setMessageBody(newVal.getBody());
		});

		aheMessageBody.getWebView().addEventFilter(KeyEvent.KEY_RELEASED, evt -> {
			currentMessageBody = aheMessageBody.getHtmlText();
			mailPreView.setMessageBody(currentMessageBody);
		});

		mailDialogView.signatureProperty().addListener((obs, oldVal, newVal) -> {
			currentSignature = newVal.getSignatureHTML();
			aheMessageBody.setHtmlText(currentMessageBody + currentSignature);
			mailPreView.setMessageBody(currentMessageBody + currentSignature);
		});
		// END
	}

	private void initConverter() {
		cboSignature.setConverter(new SignatureConverter());
		cboSelectedTemplate.setConverter(new TemplateConverter());
	}

	private void initCellFactory() {
		cboSignature.setCellFactory(new Callback<ListView<Signature>, ListCell<Signature>>() {
			@Override
			public ListCell<Signature> call(ListView<Signature> p) {
				ListCell<Signature> cell = new ListCell<Signature>() {
					@Override
					protected void updateItem(Signature item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.getSignatureName());
							setOnMouseEntered(evt -> {
								setTooltip(createToolTip(item));
							});
						}
					}
				};
				return cell;
			}
		});
	}

	private Tooltip createToolTip(Signature item) {
		Tooltip tooltip = new Tooltip();
		VBox vbBox = new VBox();
		WebView webView = new WebView();
		webView.setPrefWidth(400);
		WebEngine webEngine = webView.getEngine();
		webEngine.loadContent(item.getSignatureHTML());
		Label name = new Label(item.getSignatureName());
		name.setStyle("-fx-font-weight:bold;-fx-font-size:20;");
		vbBox.getChildren().addAll(name, webView);
		tooltip.setGraphic(vbBox);
		return tooltip;
	}

	private void registerBindings() {
		mailDialogView.selectedTransmitterProperty().bind(cboTransmitter.valueProperty());
		cboTransmitter.itemsProperty().bind(mailDialogView.transmitterItemsProperty());

		atfvRecievers.itemsProperty().bindBidirectional(mailDialogView.recieverItemsProperty());

		recieverDialogView.recieverItemsProperty().bind(atfvRecievers.itemsProperty());
		mailDialogView.subjectProperty().bind(tfSubject.textProperty());
		atfvAttachments.itemsProperty().bind(mailDialogView.attachmentItemsProperty());

		mailDialogView.personalAddressProperty().bind(tsPersonalAddress.selectedProperty());

		mailDialogView.selectedTemplateProperty().bind(cboSelectedTemplate.valueProperty());
		cboSelectedTemplate.itemsProperty().bind(mailDialogView.templateItemsProperty());

		cboSignature.itemsProperty().bind(mailDialogView.signatureItemsProperty());
		mailDialogView.signatureProperty().bind(cboSignature.valueProperty());

		vbSendImage.onMouseClickedProperty().bind(mailDialogView.onSendEmailProperty());
		btnSaveTemplate.onActionProperty().bind(mailDialogView.onSaveTemplateProperty());
	}

	/**
	 * display the list of users to be selected
	 */
	@FXML
	public void onShowRecieverDialog() {
		Alert customContentDialog = Dialogs.okCustomContentDialog(recieverDialogView, "Empfänger Liste überprüfen",
				null, mailDialogView.getScene().getWindow(), null, "OK");
		customContentDialog.showAndWait();
	}

	@FXML
	public void onShowUploadAttachments() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Anhänge bitte auswählen");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		List<File> list = fileChooser
				.showOpenMultipleDialog(Main.stage/* to be replace later */);
		if (list != null) {
			fillAdvancedTextFieldView(list);
		}
	}

	@FXML
	public void onShowAttachmentManager(ActionEvent evt) {
		deleteAllAttachments();
	}

	private void deleteAllAttachments() {
		mailDialogView.setAttachmentItems(null);
	}

	private void fillAdvancedTextFieldView(List<File> list) {
		mailDialogView.setAttachmentItems(MailDialogService.convertFileToLabelAttachment(list));
	}

	@FXML
	public void onShowPreview() {
		mailDialogView.setMessagebody(aheMessageBody.getHtmlText());
		popOver.setContentNode(mailPreView);
		popOver.setDetachable(false);
		popOver.setDetached(false);
		popOver.setArrowLocation(ArrowLocation.TOP_RIGHT);
		popOver.show(btnShowPreview);
	}

}

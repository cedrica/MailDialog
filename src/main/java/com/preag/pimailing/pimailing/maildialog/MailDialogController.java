package com.preag.pimailing.maildialog;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.ToggleSwitch;

import com.preag.core.ui.advancedhtmleditor.AdvancedHtmlEditor;
import com.preag.pimailing.maildialog.advancedtextfield.AdvancedTextFieldView;
import com.preag.pimailing.maildialog.converter.SignatureConverter;
import com.preag.pimailing.maildialog.converter.TemplateConverter;
import com.preag.pimailing.maildialog.run.Signature;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class MailDialogController implements Initializable {

	@FXML
	ComboBox cboTransmitter;
	@FXML
	AdvancedTextFieldView atfvRecievers;
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
	Button btnShowPreview;
	@FXML
	Button btnSaveTemplate;
	private String currentMessageBody = "";
	private String currentSignature = "";

	@FXML
	MailDialogView rootNode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.setPreviewButton(btnShowPreview);
		registerBindings();
		registerListener();
		atfvRecievers.setMaxNumberOfItems(6);
		initCellFactory();
		initConverter();
	}

	private void registerListener() {
		rootNode.selectedTemplateProperty().addListener((obs, oldVal, newVal) -> {
			aheMessageBody.setHtmlText(newVal.getBody());
		});

		aheMessageBody.getWebView().addEventFilter(KeyEvent.KEY_RELEASED, evt -> {
			currentMessageBody = aheMessageBody.getHtmlText();
		});

		rootNode.signatureProperty().addListener((obs, oldVal, newVal) -> {
			currentSignature = newVal.getSignatureHTML();
			aheMessageBody.setHtmlText(currentMessageBody + currentSignature);
		});
	}

	private void initConverter() {
		cboSignature.setConverter(new SignatureConverter());
		cboSelectedTemplate.setConverter(new TemplateConverter());
	}

	private void initCellFactory() {
		cboSignature.setCellFactory(CellFactorySignature.signatureWithToolTip());
	}

	private void registerBindings() {
		rootNode.selectedTransmitterProperty().bind(cboTransmitter.valueProperty());
		cboTransmitter.itemsProperty().bind(rootNode.transmitterItemsProperty());

		atfvRecievers.itemsProperty().bindBidirectional(rootNode.recieverItemsProperty());

		rootNode.subjectProperty().bind(tfSubject.textProperty());
		atfvAttachments.itemsProperty().bind(rootNode.attachmentItemsProperty());

		rootNode.personalAddressProperty().bind(tsPersonalAddress.selectedProperty());

		rootNode.selectedTemplateProperty().bind(cboSelectedTemplate.valueProperty());
		cboSelectedTemplate.itemsProperty().bind(rootNode.templateItemsProperty());

		cboSignature.itemsProperty().bind(rootNode.signatureItemsProperty());
		rootNode.signatureProperty().bind(cboSignature.valueProperty());
	}

	/**
	 * display the list of users to be selected
	 */
	@FXML
	public void onShowRecieverDialog() {
		rootNode.fireEvent(new MailDialogEvent(MailDialogEvent.RECEIVER));
	}

	@FXML
	public void onShowUploadAttachments() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Anhänge bitte auswählen");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		List<File> list = fileChooser.showOpenMultipleDialog(rootNode.getScene().getWindow());
		if (list != null) {
			fillAdvancedTextFieldView(list);
		}
	}

	@FXML
	public void onShowAttachmentManager(ActionEvent evt) {
		deleteAllAttachments();
	}

	private void deleteAllAttachments() {
		rootNode.setAttachmentItems(null);
	}

	private void fillAdvancedTextFieldView(List<File> list) {
		rootNode.setAttachmentItems(MailDialogService.convertFileToLabelAttachment(list));
	}

	@FXML
	public void onShowPreview() {
		rootNode.setMessagebody(aheMessageBody.getHtmlText());
		rootNode.fireEvent(new MailDialogEvent(MailDialogEvent.PREVIEW));
	}

	@FXML
	public void onSaveAsTemplate() {
		rootNode.fireEvent(new MailDialogEvent(MailDialogEvent.TEMPLATE));
	}
}

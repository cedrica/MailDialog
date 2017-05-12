package com.preag.pimailing.maildialog.previews;

import java.net.URL;
import java.util.ResourceBundle;

import com.preag.pimailing.maildialog.run.Signature;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;

public class MailPreViewController implements Initializable {

	@FXML
	MailPreView rootNode;
	@FXML
	Label lblTransmitter;
	@FXML
	FlowPane fpRecievers;
	@FXML
	Label lblPersonalAddress;
	@FXML
	WebView aheBody;
	@FXML
	FlowPane fpAttachments;
	@FXML
	Label lblSubject;

	private String currentMessageBody;
	private String currentSignature;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		registerBinding();
		registerListener();

	}

	private void registerBinding() {
		lblSubject.textProperty().bind(rootNode.subjectProperty());
		lblTransmitter.textProperty().bind(rootNode.transmitterProperty());
		lblPersonalAddress.textProperty().bind(rootNode.personalAdressProperty());
	}

	private void registerListener() {
		rootNode.recieversProperty().addListener((obs, oldVal, newVal) -> updateReceivers(newVal));
		rootNode.attachmentsProperty().addListener((obs, oldVal, newVal) -> updateAttachments(newVal));
		rootNode.messageBodyProperty().addListener((obs, oldVal, newVal) -> updateMessageBody(newVal));
		rootNode.signatureProperty().addListener((obs, oldVal, newVal) -> updateSignature(newVal));
	}

	private void updateSignature(Signature newVal) {
		if (newVal != null) {
			this.currentSignature = newVal.getSignatureHTML();
			rebuiltContent();
		}
	}

	private void updateMessageBody(String newVal) {
		if (newVal != null) {
			this.currentMessageBody = newVal;
			rebuiltContent();
		}
	}

	private void updateAttachments(ObservableList<String> newVal) {
		if (newVal == null || newVal.isEmpty()) {
			fpAttachments.getChildren().clear();
		}
		for (String string : newVal) {
			Label label = new Label(string);
			fpAttachments.getChildren().add(label);
		}
	}

	private void updateReceivers(ObservableList<String> newVal) {
		for (String string : newVal) {
			Label label = new Label(string);
			fpRecievers.getChildren().add(label);
		}
	}

	private void rebuiltContent() {
		aheBody.getEngine().executeScript(
				"document.body.focus();document.getElementsByTagName('body')[0].setAttribute('contenteditable', '"
						+ false + "')");
		this.currentSignature = (this.currentSignature == null || this.currentSignature.equals("null")) ? ""
				: this.currentSignature;
		aheBody.getEngine().loadContent(this.currentMessageBody + this.currentSignature);
	}

}

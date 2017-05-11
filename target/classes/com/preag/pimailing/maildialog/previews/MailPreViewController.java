package com.preag.pimailing.maildialog.previews;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;

public class MailPreViewController implements Initializable {

	// ROOTNODE
	@FXML
	MailPreView mailPreView;
	// ----------------------------
	@FXML
	Label lblTransmitter;
	@FXML
	Label lblTransmitDate;
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
	private boolean editable = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		registerBinding();
		registerListener();
	
	}

	private void registerBinding() {
		lblSubject.textProperty().bind(mailPreView.subjectProperty());
		lblTransmitter.textProperty().bind(mailPreView.transmitterProperty());
		lblTransmitDate.textProperty().bind(mailPreView.transmitDateProperty());
	}

	private void registerListener() {
		mailPreView.recieversProperty().addListener((obs, oldVal, newVal) -> {
			for (String string : newVal) {
				Label label = new Label(string);
				fpRecievers.getChildren().add(label);
			}
		});
		mailPreView.attachmentsProperty().addListener((obs, oldVal, newVal) -> {
			if(newVal == null || newVal.isEmpty()){
				fpAttachments.getChildren().clear();
			}
			for (String string : newVal) {
				Label label = new Label(string);
				fpAttachments.getChildren().add(label);
			}
		});
		
		mailPreView.removedAttachmentProperty().addListener((obs,oldVal,newVal)->{
			int index = 0;
			for (Node label:fpAttachments.getChildren()) {
				if(((Label)label).getText().equals(newVal.getText())){
					break;
				}
				index++;
			}
			fpAttachments.getChildren().remove(index);
		});
		
		lblPersonalAddress.textProperty().bind(mailPreView.personalAdressProperty());
		mailPreView.messageBodyProperty().addListener((obs, oldVal, newVal) -> {

			if (newVal != null) {
				this.currentMessageBody = newVal;
				rebuiltContent();
			}

		});
		mailPreView.signatureProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal != null) {
				this.currentSignature = newVal.getSignatureHTML();
				rebuiltContent();
			}

		});
		mailPreView.editableProperty().addListener((obs, old, newValue) -> {
			if (newValue) {
				this.editable = newValue;
			}
		});
	}

	private void rebuiltContent() {
		aheBody.getEngine().executeScript("document.body.focus();document.getElementsByTagName('body')[0].setAttribute('contenteditable', '"+this.editable+"')");
		this.currentSignature = (this.currentSignature == null || this.currentSignature.equals("null"))? "":this.currentSignature;
		aheBody.getEngine().loadContent(this.currentMessageBody + this.currentSignature);
	}

}

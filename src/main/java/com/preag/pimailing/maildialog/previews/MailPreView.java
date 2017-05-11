package com.preag.pimailing.maildialog.previews;


import com.preag.core.ui.service.FXMLService;
import com.preag.pimailing.maildialog.run.Signature;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MailPreView extends VBox {

	private StringProperty subject = new SimpleStringProperty();
	private StringProperty transmitter = new SimpleStringProperty();
	private StringProperty transmitDate = new SimpleStringProperty();
	private ListProperty<String> recievers = new SimpleListProperty<>();
	private ListProperty<String> attachments = new SimpleListProperty<>();
	private StringProperty personalAdress = new SimpleStringProperty();
	private StringProperty messageBody = new SimpleStringProperty();
	private ObjectProperty<Signature> signature = new SimpleObjectProperty<>();
	private ObjectProperty<Boolean> editable = new SimpleObjectProperty<>();
	private ObjectProperty<Label> removedAttachment = new SimpleObjectProperty<>();
	
	public MailPreView() {
		FXMLService.INSTANCE.loadView(this);
	}

	public final StringProperty transmitterProperty() {
		return this.transmitter;
	}

	public final String getTransmitter() {
		return this.transmitterProperty().get();
	}

	public final void setTransmitter(final String transmitter) {
		this.transmitterProperty().set(transmitter);
	}

	public final StringProperty transmitDateProperty() {
		return this.transmitDate;
	}

	public final String getTransmitDate() {
		return this.transmitDateProperty().get();
	}

	public final void setTransmitDate(final String transmitDate) {
		this.transmitDateProperty().set(transmitDate);
	}

	public final StringProperty personalAdressProperty() {
		return this.personalAdress;
	}

	public final String getPersonalAdress() {
		return this.personalAdressProperty().get();
	}

	public final void setPersonalAdress(final String personalAdress) {
		this.personalAdressProperty().set(personalAdress);
	}

	public final StringProperty messageBodyProperty() {
		return this.messageBody;
	}

	public final String getMessageBody() {
		return this.messageBodyProperty().get();
	}

	public final void setMessageBody(final String messageBody) {
		this.messageBodyProperty().set(messageBody);
	}

	public final ObjectProperty<Signature> signatureProperty() {
		return this.signature;
	}

	public final Signature getSignature() {
		return this.signatureProperty().get();
	}

	public final void setSignature(final Signature signature) {
		this.signatureProperty().set(signature);
	}

	public final StringProperty subjectProperty() {
		return this.subject;
	}

	public final String getSubject() {
		return this.subjectProperty().get();
	}

	public final void setSubject(final String subject) {
		this.subjectProperty().set(subject);
	}

	public final ListProperty<String> recieversProperty() {
		return this.recievers;
	}

	public final ObservableList<String> getRecievers() {
		return this.recieversProperty().get();
	}

	public final void setRecievers(final ObservableList<String> recievers) {
		this.recieversProperty().set(recievers);
	}

	public final ListProperty<String> attachmentsProperty() {
		return this.attachments;
	}

	public final ObservableList<String> getAttachments() {
		return this.attachmentsProperty().get();
	}

	public final void setAttachments(final ObservableList<String> attachments) {
		this.attachmentsProperty().set(attachments);
	}

	public final ObjectProperty<Boolean> editableProperty() {
		return this.editable;
	}
	

	public final boolean isEditable() {
		return this.editableProperty().get();
	}
	

	public final void setEditable(final boolean editable) {
		this.editableProperty().set(editable);
	}

	public final ObjectProperty<Label> removedAttachmentProperty() {
		return this.removedAttachment;
	}
	

	public final Label getRemovedAttachment() {
		return this.removedAttachmentProperty().get();
	}
	

	public final void setRemovedAttachment(final Label removedAttachment) {
		this.removedAttachmentProperty().set(removedAttachment);
	}

	
}

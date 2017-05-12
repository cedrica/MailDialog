package com.preag.pimailing.maildialog;

import java.util.ArrayList;

import com.preag.core.ui.service.FXMLService;
import com.preag.pimailing.maildialog.run.Signature;
import com.preag.pimailing.maildialog.run.Template;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MailDialogView extends BorderPane {
	private ObjectProperty<String> selectedTransmitter = new SimpleObjectProperty<>();
	private ListProperty<String> transmitterItems = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<>()));
	private ListProperty<Label> recieverItems = new SimpleListProperty<>();
	private StringProperty subject = new SimpleStringProperty();
	private ListProperty<Label> attachmentItems = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<>()));
	private BooleanProperty personalAddress = new SimpleBooleanProperty(false);
	private ObjectProperty<Template> selectedTemplate = new SimpleObjectProperty<>();
	private ListProperty<Template> templateItems = new SimpleListProperty<>();
	private StringProperty messagebody = new SimpleStringProperty();
	private ObjectProperty<Signature> signature = new SimpleObjectProperty<>();
	private ListProperty<Signature> signatureItems = new SimpleListProperty<>();

	private ObjectProperty<Button> previewButton = new SimpleObjectProperty<>();

	public MailDialogView() {
		super();
		FXMLService.INSTANCE.loadView(this);
	}

	public final ObjectProperty<String> selectedTransmitterProperty() {
		return this.selectedTransmitter;
	}

	public final String getSelectedTransmitter() {
		return this.selectedTransmitterProperty().get();
	}

	public final void setSelectedTransmitter(final String transmitter) {
		this.selectedTransmitterProperty().set(transmitter);
	}

	public final ListProperty<Label> recieverItemsProperty() {
		return this.recieverItems;
	}

	public final ObservableList<Label> getRecieverItems() {
		return this.recieverItemsProperty().get();
	}

	public final void setRecieverItems(final ObservableList<Label> recieverItems) {
		this.recieverItemsProperty().set(recieverItems);
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

	public final ListProperty<Label> attachmentItemsProperty() {
		return this.attachmentItems;
	}

	public final ObservableList<Label> getAttachmentItems() {
		return this.attachmentItemsProperty().get();
	}

	public final void setAttachmentItems(final ObservableList<Label> attachmentItems) {
		this.attachmentItemsProperty().set(attachmentItems);
	}

	public final BooleanProperty personalAddressProperty() {
		return this.personalAddress;
	}

	public final boolean isPersonalAddress() {
		return this.personalAddressProperty().get();
	}

	public final void setPersonalAddress(final boolean personalAddress) {
		this.personalAddressProperty().set(personalAddress);
	}

	public final ObjectProperty<Template> selectedTemplateProperty() {
		return this.selectedTemplate;
	}

	public final Object getSelectedTemplate() {
		return this.selectedTemplateProperty().get();
	}

	public final void setSelectedTemplate(final Template selectedTemplate) {
		this.selectedTemplateProperty().set(selectedTemplate);
	}

	public final StringProperty messagebodyProperty() {
		return this.messagebody;
	}

	public final String getMessagebody() {
		return this.messagebodyProperty().get();
	}

	public final void setMessagebody(final String messagebody) {
		this.messagebodyProperty().set(messagebody);
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

	public final ListProperty<String> transmitterItemsProperty() {
		return this.transmitterItems;
	}

	public final ObservableList<String> getTransmitterItems() {
		return this.transmitterItemsProperty().get();
	}

	public final void setTransmitterItems(final ObservableList<String> transmitterItems) {
		this.transmitterItemsProperty().set(transmitterItems);
	}

	public final ListProperty<Signature> signatureItemsProperty() {
		return this.signatureItems;
	}

	public final ObservableList<Signature> getSignatureItems() {
		return this.signatureItemsProperty().get();
	}

	public final void setSignatureItems(final ObservableList<Signature> signatureItems) {
		this.signatureItemsProperty().set(signatureItems);
	}

	public final ListProperty<Template> templateItemsProperty() {
		return this.templateItems;
	}

	public final ObservableList<Template> getTemplateItems() {
		return this.templateItemsProperty().get();
	}

	public final void setTemplateItems(final ObservableList<Template> templateItems) {
		this.templateItemsProperty().set(templateItems);
	}

	public final ObjectProperty<Button> previewButtonProperty() {
		return this.previewButton;
	}

	public final Button getPreviewButton() {
		return this.previewButtonProperty().get();
	}

	public final void setPreviewButton(final Button previewButton) {
		this.previewButtonProperty().set(previewButton);
	}
}

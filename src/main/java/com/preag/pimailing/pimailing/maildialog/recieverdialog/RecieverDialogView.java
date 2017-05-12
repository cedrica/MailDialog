package com.preag.pimailing.maildialog.recieverdialog;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class RecieverDialogView extends BorderPane {
	private ObjectProperty<ObservableList<Label>> recieverItems = new SimpleObjectProperty<>();

	public RecieverDialogView() {
		FXMLService.INSTANCE.loadView(this);
	}

	public final ObjectProperty<ObservableList<Label>> recieverItemsProperty() {
		return this.recieverItems;
	}
	

	public final ObservableList<Label> getRecieverItems() {
		return this.recieverItemsProperty().get();
	}
	

	public final void setRecieverItems(final ObservableList<Label> recieverItems) {
		this.recieverItemsProperty().set(recieverItems);
	}
	



}

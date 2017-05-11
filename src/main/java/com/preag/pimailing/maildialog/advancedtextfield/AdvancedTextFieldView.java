package com.preag.pimailing.maildialog.advancedtextfield;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AdvancedTextFieldView extends HBox {
	private ObjectProperty<Label> item = new SimpleObjectProperty<Label>();
	private ObjectProperty<ObservableList<Label>> items = new SimpleObjectProperty<ObservableList<Label>>();
	private int maxNumberOfItems = -1;

	public AdvancedTextFieldView() {
		super();
		FXMLService.INSTANCE.loadView(this);
	}

	public final ObjectProperty<Label> itemProperty() {
		return this.item;
	}

	public final Label getItem() {
		return this.itemProperty().get();
	}

	public final void setItem(final Label toAdd) {
		this.itemProperty().set(toAdd);
	}

	public final ObjectProperty<ObservableList<Label>> itemsProperty() {
		return this.items;
	}

	public final ObservableList<Label> getItems() {
		return this.itemsProperty().get();
	}

	public final void setItems(final ObservableList<Label> items) {
		this.itemsProperty().set(items);
	}

	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}

	/**
	 * set the max number of items in the TextField
	 * 
	 * @param limit
	 */
	public void setMaxNumberOfItems(int limit) {
		this.maxNumberOfItems = limit;
	}

}

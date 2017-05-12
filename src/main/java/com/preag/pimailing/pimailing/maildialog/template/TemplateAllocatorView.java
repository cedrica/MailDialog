package com.preag.pimailing.maildialog.template;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.VBox;

public class TemplateAllocatorView extends VBox {

private StringProperty templateName = new SimpleStringProperty();

	public TemplateAllocatorView() {
		FXMLService.INSTANCE.loadView(this);
	}

	public final StringProperty templateNameProperty() {
		return this.templateName;
	}
	

	public final String getTemplateName() {
		return this.templateNameProperty().get();
	}
	

	public final void setTemplateName(final String templateName) {
		this.templateNameProperty().set(templateName);
	}
	
	
	

}

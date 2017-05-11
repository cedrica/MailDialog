package com.preag.pimailing.maildialog.template;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class TemplateAllocatorController implements Initializable {

	@FXML
	TextField tfTemplateName;
	@FXML
	TemplateAllocatorView templateAllocatorView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		templateAllocatorView.templateNameProperty().bind(tfTemplateName.textProperty());
	}

}

package com.preag.pimailing.maildialog.advancedtextfield;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class AdvancedTextFieldController implements Initializable {

	@FXML
	AdvancedTextFieldView advancedTextFieldView;
	@FXML
	FlowPane fpLabelContainer;
	private int counter = 0;
	private boolean jusOneTime = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		registerListener();
	}

	private void registerListener() {
		advancedTextFieldView.itemsProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal == null) {
				fpLabelContainer.getChildren().clear();
			} else {
				for (Label item : newVal) {
					if (!contains(item, fpLabelContainer.getChildren())) {
						addRecieverAndRegisterAction(item);
					}
				}
			}

		});

		advancedTextFieldView.itemProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal == null) {
				fpLabelContainer.getChildren().clear();
			} else {
				if (!contains(newVal, fpLabelContainer.getChildren())) {
					addRecieverAndRegisterAction(newVal);
					advancedTextFieldView.getItems().add(newVal);
				}
			}

		});
	}

	private void addRecieverAndRegisterAction(Label newVal) {
		boolean limitReached = (advancedTextFieldView.getMaxNumberOfItems() > 0)
				? ++counter > advancedTextFieldView.getMaxNumberOfItems() : false;
		if (!limitReached) {
			newVal.setOnMouseClicked(evt -> onRecieverDoubleCick(evt, newVal));
			fpLabelContainer.getChildren().add(newVal);
		} else if (limitReached && jusOneTime) {
			jusOneTime = false;
			Label label = new Label("...");
			label.setStyle("-fx-underline:false;");
			fpLabelContainer.getChildren().add(label);
		}
	}

	public void onRecieverDoubleCick(MouseEvent event, Label me) {
		if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
			for (Node reciever : fpLabelContainer.getChildren()) {
				reciever.setStyle("-fx-background-color:#fff;-fx-text-fill:#000");
			}
			me.setStyle("-fx-background-color:#333;-fx-text-fill:#fff");
			me.getScene().addEventHandler(KeyEvent.KEY_RELEASED, evt -> {
				if (evt.getCode() == KeyCode.DELETE) {
					fpLabelContainer.getChildren().remove(me);
					advancedTextFieldView.getItems().clear();
					ObservableList<String> newList = FXCollections.observableList(new ArrayList<>());
					for (Node label : fpLabelContainer.getChildren()) {
						newList.add(((Label) label).getText());
					}
					advancedTextFieldView
							.fireEvent(new AdvancedTextFieldEvent(AdvancedTextFieldEvent.SPEAK_TO_MY_SELF, newList));
				}
			});
		}
	}

	private boolean contains(Node node, ObservableList<Node> list) {
		for (Node node2 : list) {
			if (node.getId().equals(node2.getId()))
				return true;
			else
				continue;
		}
		return false;
	}

}

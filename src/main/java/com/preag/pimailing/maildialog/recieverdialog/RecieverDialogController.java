package com.preag.pimailing.maildialog.recieverdialog;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.preag.pimailing.maildialog.run.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RecieverDialogController implements Initializable {

	@FXML
	RecieverDialogView rootNode;
	@FXML
	TableView<User> tvRecievers;
	@FXML
	TextField tfLookForReciever;
	private ObservableList<User> users;
	@FXML
	TableColumn<User, String> tbcFirstName;
	@FXML
	TableColumn<User, String> tbcLastName;
	@FXML
	TableColumn<User, String> tbcEmail;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tbcFirstName.setCellValueFactory(param -> param.getValue().vorNameProperty());
		tbcLastName.setCellValueFactory(param -> param.getValue().nachNameProperty());
		tbcEmail.setCellValueFactory(param -> param.getValue().emailProperty());

		rootNode.recieverItemsProperty().addListener((obs, oldVal, newVal) -> updateReciverItemList(newVal));

		tfLookForReciever.setOnKeyReleased(evt -> searchForReceiver(tfLookForReciever.getText()));
	}

	private void searchForReceiver(String searchText) {
		if (users != null && !users.isEmpty()) {
			List<User> collect = users.stream().filter(p -> {
				return p.getNachName().startsWith(searchText) || p.getVorName().startsWith(searchText)
						|| p.getEmail().startsWith(searchText);
			}).collect(Collectors.toList());
			tvRecievers.setItems(FXCollections.observableList(collect));
		}
	}

	private void updateReciverItemList(ObservableList<Label> newVal) {
		if (newVal != null) {
			users = retrieveUsers(newVal);
			tvRecievers.setItems(users);
		}
	}

	private ObservableList<User> retrieveUsers(ObservableList<Label> usersLabel) {
		ObservableList<User> users = FXCollections.observableList(new ArrayList<>());
		for (Label label : usersLabel) {
			users.add((User) label.getUserData());
		}
		return users;
	}

}

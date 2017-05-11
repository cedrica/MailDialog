package basic.list;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class BasicListController implements Initializable {

	@FXML
	BasicListView rootNode;
	@FXML
	Label lblAmountOfNames;
	@FXML
	ListView<String> lvNameList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lvNameList.itemsProperty().bindBidirectional(rootNode.nameListProperty());
		rootNode.nameListProperty().addListener((obs, oldVal, newVal) -> updateAmountOfNames(newVal));
	}

	private void updateAmountOfNames(ObservableList<String> newVal) {
		if (newVal != null) {
			lblAmountOfNames.setText(newVal.size() + "");
		} else {
			lblAmountOfNames.setText("0");
		}
	}

}

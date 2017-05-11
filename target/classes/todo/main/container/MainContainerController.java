package todo.main.container;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainContainerController implements Initializable {

	@FXML
	MainContainerView rootNode;
	@FXML
	VBox vbxNavigation;
	@FXML
	HBox hbxCenter;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.setCenterHBox(hbxCenter);
		rootNode.setFilterVBox(vbxNavigation);
		rootNode.centerHBoxBackgroundColorProperty()
				.addListener((obs, oldVal, newVal) -> updateBackgroundColor(newVal, hbxCenter));
		rootNode.filterbarBackgroundColorProperty()
				.addListener((obs, oldVal, newVal) -> updateBackgroundColor(newVal, vbxNavigation));
	}

	private void updateBackgroundColor(String newVal, Node node) {
		node.setStyle("-fx-background-color:" + newVal);
	}

	@FXML
	public void onSettings() {
		rootNode.fireEvent(new MainContainerEvent(MainContainerEvent.SETTINGS));
	}

}

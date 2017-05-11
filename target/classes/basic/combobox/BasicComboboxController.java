package basic.combobox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class BasicComboboxController implements Initializable {

	@FXML
	BasicComboboxView rootNode;
	@FXML
	ComboBox<String> cmbName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbName.itemsProperty().bind(rootNode.nameListProperty());
	}

}

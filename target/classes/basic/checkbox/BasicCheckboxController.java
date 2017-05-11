package basic.checkbox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class BasicCheckboxController implements Initializable {

	@FXML
	BasicCheckboxView rootNode;
	@FXML
	Label lblProfession;
	@FXML
	Label lblName;
	@FXML
	CheckBox chkbName;
	@FXML
	CheckBox chkbProfession;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblName.disableProperty().bind(chkbName.selectedProperty());
		lblProfession.visibleProperty().bind(chkbProfession.selectedProperty().not());
	}

}

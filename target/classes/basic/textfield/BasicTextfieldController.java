package basic.textfield;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BasicTextfieldController implements Initializable {

	@FXML
	BasicTextFieldView rootNode;
	@FXML
	TextField txfUserName;
	@FXML
	Label lblUserName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.userNameProperty().bindBidirectional(txfUserName.textProperty());

		lblUserName.textProperty().bind(rootNode.userNameProperty());
	}
}

package basic.button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BasicButtonController implements Initializable {

	@FXML
	BasicButtonView rootNode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void onLogin() {
		rootNode.setLoginCounter(rootNode.getLoginCounter() + 1);
		rootNode.fireEvent(new BasicButtonEvent(BasicButtonEvent.LOGIN));
	}
}

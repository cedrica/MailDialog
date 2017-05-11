package basic.datepicker;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

public class BasicDatePickerController implements Initializable {

	@FXML
	DatePicker dpkBirthday;
	@FXML
	BasicDatePickerView rootNode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.selectedDateProperty().bindBidirectional(dpkBirthday.valueProperty());
	}

	@FXML
	public void onBirthdaySelect() {
		rootNode.fireEvent(new BasicDatePickerEvent(BasicDatePickerEvent.SELET_BIRTHDAY));
	}
}

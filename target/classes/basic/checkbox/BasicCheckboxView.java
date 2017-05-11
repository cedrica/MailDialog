package basic.checkbox;

import com.preag.core.ui.service.FXMLService;

import javafx.scene.layout.BorderPane;

public class BasicCheckboxView extends BorderPane{
	private static final String FXML = "/basic/checkbox/BasicCheckboxView.fxml";

	public BasicCheckboxView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}
}

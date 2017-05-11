package basic.componentskeleton;

import com.preag.core.ui.service.FXMLService;

import javafx.scene.layout.BorderPane;

public class EmptyExampleView extends BorderPane{
	
	private static final String FXML = "/basic/componentskeleton/EmptyExampleView.fxml";
	
	public EmptyExampleView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

}

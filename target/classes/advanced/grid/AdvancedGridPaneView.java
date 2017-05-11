package advanced.grid;

import com.preag.core.ui.service.FXMLService;

import javafx.scene.layout.BorderPane;

public class AdvancedGridPaneView extends BorderPane {
	public AdvancedGridPaneView() {
		super();
		FXMLService.INSTANCE.loadView(this);
	}
}

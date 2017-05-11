package advanced.grid;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class AdvancedGridPaneController implements Initializable {

	@FXML
	AdvancedGridPaneView rootNode;
	@FXML
	GridPane gpnMainGrid;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gpnMainGrid.setGridLinesVisible(false);
	}
}

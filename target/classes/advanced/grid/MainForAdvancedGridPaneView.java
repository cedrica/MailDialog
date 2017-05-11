package advanced.grid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForAdvancedGridPaneView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AdvancedGridPaneView advancedGridPaneView = new AdvancedGridPaneView();
		
		Scene scene = new Scene(advancedGridPaneView);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

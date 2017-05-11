package basic.componentskeleton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForEmptyExampleView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		EmptyExampleView emptyExampleView = new EmptyExampleView();
		Scene scene = new Scene(emptyExampleView);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

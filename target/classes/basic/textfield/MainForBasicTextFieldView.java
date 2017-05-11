package basic.textfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForBasicTextFieldView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new BasicTextFieldView());
		scene.getStylesheets().add("/css/Material.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

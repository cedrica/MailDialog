package basic.combobox;

import helper.database.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForBasicCombobox extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BasicComboboxView basicComboboxView = new BasicComboboxView();
		basicComboboxView.setNameList(FXCollections.observableArrayList(Database.getAllNames()));

		Scene scene = new Scene(basicComboboxView);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

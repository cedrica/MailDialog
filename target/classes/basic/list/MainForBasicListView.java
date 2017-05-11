package basic.list;

import helper.database.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForBasicListView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BasicListView basicListView = new BasicListView();
		basicListView.setNameList(FXCollections.observableArrayList(Database.getAllNames()));

		Scene scene = new Scene(basicListView);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

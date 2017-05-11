package advanced.table;

import helper.database.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForAdvancedTableView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AdvancedTableView advancedTableView = new AdvancedTableView();
		advancedTableView.setAllCharacters(FXCollections.observableArrayList(Database.getAllCharacters()));

		Scene scene = new Scene(advancedTableView);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

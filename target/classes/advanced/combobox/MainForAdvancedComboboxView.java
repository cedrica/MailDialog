package advanced.combobox;

import helper.database.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForAdvancedComboboxView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AdvancedComboboxView advancedComboboxView = new AdvancedComboboxView();
		advancedComboboxView.setCharacterList(FXCollections.observableArrayList(Database.getAllCharacters()));
		
		Scene scene = new Scene(advancedComboboxView);
		scene.getStylesheets().add("/css/Material.css");
		scene.addEventHandler(AdvancedComboboxEvent.SELECT_CHARACTER, evt -> onSelectedNewCharacter(evt));

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onSelectedNewCharacter(AdvancedComboboxEvent event) {
		AdvancedComboboxView target = (AdvancedComboboxView) event.getTarget();
		System.out.println("You select: " + target.getSelectedCharacter().getName());
	}
}

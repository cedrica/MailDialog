package advanced.dialog;

import java.util.Optional;

import basic.textfield.BasicTextFieldView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainForDialog extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox container = createContainer(primaryStage);
		Scene scene = new Scene(container);
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox createContainer(Stage primaryStage) {
		HBox container = new HBox();
		container.setPadding(new Insets(10, 10, 10, 10));
		container.setAlignment(Pos.CENTER);

		Button openNodeDialog = new Button();
		openNodeDialog.setText("Open custom dialog with node");
		openNodeDialog.setOnAction(evt -> openDialogWithNodeContent(evt, primaryStage));

		Button openAlertDialog = new Button();
		openAlertDialog.setText("Open alert dialog");
		openAlertDialog.setOnAction(evt -> openAlertDialig(evt, primaryStage));

		container.getChildren().addAll(openNodeDialog, openAlertDialog);
		return container;
	}

	public void openDialogWithNodeContent(ActionEvent event, Window parentWindow) {
		Dialog<ButtonType> newDialog = new Dialog<>();
		newDialog.setTitle("New Dialog");
		newDialog.initOwner(parentWindow);

		newDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		newDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
		newDialog.getDialogPane().setContent(new BasicTextFieldView());

		Optional<ButtonType> buttonResult = newDialog.showAndWait();
		if (buttonResult.get() == ButtonType.OK) {
			System.out.println("You clicked on the 'OK' button");
		}
	}

	public void openAlertDialig(ActionEvent event, Window parentWindow) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("This is a warning!");
		alert.setContentText("But just ignore it, it's not that important!");
		alert.initOwner(parentWindow);
		alert.showAndWait();
	}
}

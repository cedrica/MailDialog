package advanced.popover;

import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;

import basic.textfield.BasicTextFieldView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainForPopover extends Application {
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

		Button staticPopOver = new Button();
		staticPopOver.setText("Open a fixed popover");
		staticPopOver.setOnAction(evt -> openStaticPopover(evt, staticPopOver));

		Button dynamicPopOver = new Button();
		dynamicPopOver.setText("Open a dynamic popover");
		dynamicPopOver.setOnAction(evt -> openDynamicPopover(evt, dynamicPopOver));

		container.getChildren().addAll(staticPopOver, dynamicPopOver);
		return container;
	}

	private void openStaticPopover(ActionEvent evt, Button parentNode) {
		PopOver popOver = new PopOver();
		popOver.setDetachable(false);
		popOver.setHideOnEscape(false);
		popOver.setArrowLocation(ArrowLocation.TOP_CENTER);
		popOver.setContentNode(new BasicTextFieldView());
		
		parentNode.getScene().getWindow().setOnCloseRequest(event -> closePopOver(popOver));
		
		popOver.show(parentNode);
	}

	private void openDynamicPopover(ActionEvent evt, Button parentNode) {
		PopOver popOver = new PopOver();
		popOver.setTitle("Dynamic PopOver");
		popOver.setHeaderAlwaysVisible(true);
		popOver.setDetachable(true);
		popOver.setArrowLocation(ArrowLocation.LEFT_BOTTOM);
		popOver.setContentNode(new BasicTextFieldView());

		parentNode.getScene().getWindow().setOnCloseRequest(event -> closePopOver(popOver));

		popOver.show(parentNode);
	}

	private void closePopOver(PopOver popOver) {
		if (popOver != null) {
			popOver.hide(Duration.millis(0));
		}
	}
}
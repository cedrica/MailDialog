package basic.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForBasicButtonView extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new BasicButtonView());
		scene.addEventHandler(BasicButtonEvent.LOGIN, evt -> onLogin(evt));
		scene.getStylesheets().add("/css/Material.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onLogin(BasicButtonEvent event) {
		BasicButtonView target = (BasicButtonView) event.getTarget();
		System.out.println("You are the " + target.getLoginCounter().intValue()
				+" creature who trys to login. Unfortunately the loginservers are offline. Please try again later.");
	}
}

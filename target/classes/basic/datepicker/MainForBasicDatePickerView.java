package basic.datepicker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForBasicDatePickerView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new BasicDatePickerView());
		scene.addEventHandler(BasicDatePickerEvent.SELET_BIRTHDAY, evt -> onSelectBirthday(evt));
		scene.getStylesheets().add("/css/Material.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onSelectBirthday(BasicDatePickerEvent event) {
		BasicDatePickerView target = (BasicDatePickerView) event.getTarget();
		LocalDate today = LocalDate.now();
		LocalDate selectedDate = target.getSelectedDate();
		long daysBetween = ChronoUnit.DAYS.between(today, selectedDate);
		if (daysBetween == 0) {
			System.out.println("Happy Birthday, if you havn't lied!");
		} else if (daysBetween == 1) {
			System.out.println("Your Birthday is in " + daysBetween + " Day");
		} else {
			if (daysBetween < 0) {
				daysBetween += 365;
			}
			System.out.println("Your Birthday is in " + daysBetween + " Days");
		}
	}
}

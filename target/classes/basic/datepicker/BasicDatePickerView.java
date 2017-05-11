package basic.datepicker;

import java.time.LocalDate;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.BorderPane;

public class BasicDatePickerView extends BorderPane {
	private static final String FXML = "/basic/datepicker/BasicDatePickerView.fxml";

	private ObjectProperty<LocalDate> selectedDate = new SimpleObjectProperty<>(LocalDate.now());

	public BasicDatePickerView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

	public final ObjectProperty<LocalDate> selectedDateProperty() {
		return this.selectedDate;
	}

	public final LocalDate getSelectedDate() {
		return this.selectedDateProperty().get();
	}

	public final void setSelectedDate(final LocalDate selectedDate) {
		this.selectedDateProperty().set(selectedDate);
	}
}

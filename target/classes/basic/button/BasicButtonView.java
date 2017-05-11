package basic.button;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.BorderPane;

public class BasicButtonView extends BorderPane {
	private static final String FXML = "/basic/button/BasicButtonView.fxml";

	private ObjectProperty<Double> loginCounter = new SimpleObjectProperty<>(0d);

	public BasicButtonView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

	public final ObjectProperty<Double> loginCounterProperty() {
		return this.loginCounter;
	}

	public final Double getLoginCounter() {
		return this.loginCounterProperty().get();
	}

	public final void setLoginCounter(final Double loginCounter) {
		this.loginCounterProperty().set(loginCounter);
	}
}

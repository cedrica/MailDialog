package basic.textfield;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.BorderPane;

public class BasicTextFieldView extends BorderPane {
	private static final String FXML = "/basic/textfield/BasicTextFieldView.fxml";

	private StringProperty userName = new SimpleStringProperty();

	private ObjectProperty<Double> loginCounter = new SimpleObjectProperty<>(0d);

	public BasicTextFieldView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

	public final StringProperty userNameProperty() {
		return this.userName;
	}

	public final String getUserName() {
		return this.userNameProperty().get();
	}

	public final void setUserName(final String userName) {
		this.userNameProperty().set(userName);
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

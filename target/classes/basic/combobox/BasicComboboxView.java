package basic.combobox;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class BasicComboboxView extends BorderPane {

	private static final String FXML = "/basic/combobox/BasicComboboxView.fxml";

	private ObjectProperty<ObservableList<String>> nameList = new SimpleObjectProperty<>();

	public BasicComboboxView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

	public final ObjectProperty<ObservableList<String>> nameListProperty() {
		return this.nameList;
	}

	public final ObservableList<String> getNameList() {
		return this.nameListProperty().get();
	}

	public final void setNameList(final ObservableList<String> nameList) {
		this.nameListProperty().set(nameList);
	}
}

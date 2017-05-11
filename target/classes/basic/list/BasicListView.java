package basic.list;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class BasicListView extends BorderPane {
	private static final String FXML = "/basic/list/BasicListView.fxml";

	private ObjectProperty<ObservableList<String>> nameList = new SimpleObjectProperty<>();

	public BasicListView() {
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

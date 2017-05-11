package todo.main.container;

import javax.inject.Singleton;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Singleton
public class MainContainerView extends BorderPane {
	private ObjectProperty<Node> headerContentNode = new SimpleObjectProperty<>();
	private ObjectProperty<Node> bottomContentNode = new SimpleObjectProperty<>();

	/**
	 * The RGB Value as String
	 */
	private StringProperty centerHBoxBackgroundColor = new SimpleStringProperty("#F8F8FF");
	/**
	 * The RGB Value as String
	 */
	private StringProperty filterbarBackgroundColor = new SimpleStringProperty("#F5F5F5");

	private ObjectProperty<HBox> centerHBox = new SimpleObjectProperty<>();
	private ObjectProperty<VBox> filterVBox = new SimpleObjectProperty<>();

	private final String FXML = "/todo/main/container/MainContainerView.fxml";

	public MainContainerView() {
		super();
		FXMLService.INSTANCE.loadView(FXML, this);
	}

	public final ObjectProperty<Node> headerContentNodeProperty() {
		return this.headerContentNode;
	}

	public final Node getHeaderContentNode() {
		return this.headerContentNodeProperty().get();
	}

	public final void setHeaderContentNode(final Node headerContentNode) {
		this.headerContentNodeProperty().set(headerContentNode);
	}

	public final ObjectProperty<HBox> centerHBoxProperty() {
		return this.centerHBox;
	}

	public final HBox getCenterHBox() {
		return this.centerHBoxProperty().get();
	}

	public final void setCenterHBox(final HBox centerHBox) {
		this.centerHBoxProperty().set(centerHBox);
	}

	public final ObjectProperty<Node> bottomContentNodeProperty() {
		return this.bottomContentNode;
	}

	public final Node getBottomContentNode() {
		return this.bottomContentNodeProperty().get();
	}

	public final void setBottomContentNode(final Node bottomContentNode) {
		this.bottomContentNodeProperty().set(bottomContentNode);
	}

	public final StringProperty centerHBoxBackgroundColorProperty() {
		return this.centerHBoxBackgroundColor;
	}

	/**
	 * The RGB Value as String
	 */
	public final String getCenterHBoxBackgroundColor() {
		return this.centerHBoxBackgroundColorProperty().get();
	}

	public final void setCenterHBoxBackgroundColor(final String centerHBoxBackgroundColor) {
		this.centerHBoxBackgroundColorProperty().set(centerHBoxBackgroundColor);
	}

	/**
	 * The RGB Value as String
	 */
	public final StringProperty filterbarBackgroundColorProperty() {
		return this.filterbarBackgroundColor;
	}

	public final String getFilterbarBackgroundColor() {
		return this.filterbarBackgroundColorProperty().get();
	}

	public final void setFilterbarBackgroundColor(final String filterbarBackgroundColor) {
		this.filterbarBackgroundColorProperty().set(filterbarBackgroundColor);
	}

	public final ObjectProperty<VBox> filterVBoxProperty() {
		return this.filterVBox;
	}

	public final VBox getFilterVBox() {
		return this.filterVBoxProperty().get();
	}

	public final void setFilterVBox(final VBox filterVBox) {
		this.filterVBoxProperty().set(filterVBox);
	}
}

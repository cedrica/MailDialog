package helper.entities;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FXBranch {
	private final LongProperty id = new SimpleLongProperty();
	private final StringProperty name = new SimpleStringProperty();
	private final StringProperty abbrev = new SimpleStringProperty();

	public final LongProperty idProperty() {
		return this.id;
	}

	public final long getId() {
		return this.idProperty().get();
	}

	public final void setId(final long id) {
		this.idProperty().set(id);
	}

	public final StringProperty nameProperty() {
		return this.name;
	}

	public final String getName() {
		return this.nameProperty().get();
	}

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}

	public final StringProperty abbrevProperty() {
		return this.abbrev;
	}

	public final String getAbbrev() {
		return this.abbrevProperty().get();
	}

	public final void setAbbrev(final String abbrev) {
		this.abbrevProperty().set(abbrev);
	}

}

package helper.entities;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class FXProject {
	private final LongProperty id = new SimpleLongProperty();
	private final StringProperty name = new SimpleStringProperty();
	private final StringProperty abbrev = new SimpleStringProperty();
	private final StringProperty marketingName = new SimpleStringProperty();
	private final StringProperty zipCode = new SimpleStringProperty();
	private final ObjectProperty<ObservableList<FXEstate>> estateList = new SimpleObjectProperty<>();

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

	public final StringProperty marketingNameProperty() {
		return this.marketingName;
	}

	public final String getMarketingName() {
		return this.marketingNameProperty().get();
	}

	public final void setMarketingName(final String marketingName) {
		this.marketingNameProperty().set(marketingName);
	}

	public final StringProperty zipCodeProperty() {
		return this.zipCode;
	}

	public final String getZipCode() {
		return this.zipCodeProperty().get();
	}

	public final void setZipCode(final String zipCode) {
		this.zipCodeProperty().set(zipCode);
	}

	public final ObjectProperty<ObservableList<FXEstate>> estateListProperty() {
		return this.estateList;
	}

	public final ObservableList<FXEstate> getEstateList() {
		return this.estateListProperty().get();
	}

	public final void setEstateList(final ObservableList<FXEstate> estateList) {
		this.estateListProperty().set(estateList);
	}

}

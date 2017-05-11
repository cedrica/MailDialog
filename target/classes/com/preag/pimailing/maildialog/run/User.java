package com.preag.pimailing.maildialog.run;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	private LongProperty id = new SimpleLongProperty();
	private StringProperty vorName = new SimpleStringProperty();
	private StringProperty nachName = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	public final LongProperty idProperty() {
		return this.id;
	}
	
	public final long getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final long id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty vorNameProperty() {
		return this.vorName;
	}
	
	public final String getVorName() {
		return this.vorNameProperty().get();
	}
	
	public final void setVorName(final String vorName) {
		this.vorNameProperty().set(vorName);
	}
	
	public final StringProperty nachNameProperty() {
		return this.nachName;
	}
	
	public final String getNachName() {
		return this.nachNameProperty().get();
	}
	
	public final void setNachName(final String nachName) {
		this.nachNameProperty().set(nachName);
	}
	
	public final StringProperty emailProperty() {
		return this.email;
	}
	
	public final String getEmail() {
		return this.emailProperty().get();
	}
	
	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	


	
}

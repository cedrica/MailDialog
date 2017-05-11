package helper.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class CharacterObject {

	private StringProperty name = new SimpleStringProperty();
	private ObjectProperty<Image> characterImage = new SimpleObjectProperty<>();
	private ObjectProperty<Double> hitpoints = new SimpleObjectProperty<>();
	private ObjectProperty<Double> mana = new SimpleObjectProperty<>();
	private ObjectProperty<Double> attack = new SimpleObjectProperty<>();
	private ObjectProperty<Double> defence = new SimpleObjectProperty<>();

	public CharacterObject(String name, Image characterImage, double hitpoints, double mana, double attack,
			double defence) {
		super();
		setName(name);
		setCharacterImage(characterImage);
		setHitpoints(hitpoints);
		setMana(mana);
		setAttack(attack);
		setDefence(defence);
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

	public final ObjectProperty<Image> characterImageProperty() {
		return this.characterImage;
	}

	public final Image getCharacterImage() {
		return this.characterImageProperty().get();
	}

	public final void setCharacterImage(final Image characterImage) {
		this.characterImageProperty().set(characterImage);
	}

	public final ObjectProperty<Double> hitpointsProperty() {
		return this.hitpoints;
	}

	public final Double getHitpoints() {
		return this.hitpointsProperty().get();
	}

	public final void setHitpoints(final Double hitpoints) {
		this.hitpointsProperty().set(hitpoints);
	}

	public final ObjectProperty<Double> manaProperty() {
		return this.mana;
	}

	public final Double getMana() {
		return this.manaProperty().get();
	}

	public final void setMana(final Double mana) {
		this.manaProperty().set(mana);
	}

	public final ObjectProperty<Double> attackProperty() {
		return this.attack;
	}

	public final Double getAttack() {
		return this.attackProperty().get();
	}

	public final void setAttack(final Double attack) {
		this.attackProperty().set(attack);
	}

	public final ObjectProperty<Double> defenceProperty() {
		return this.defence;
	}

	public final Double getDefence() {
		return this.defenceProperty().get();
	}

	public final void setDefence(final Double defence) {
		this.defenceProperty().set(defence);
	}
}

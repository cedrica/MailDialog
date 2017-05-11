package advanced.combobox;

import com.preag.core.ui.service.FXMLService;

import helper.entities.CharacterObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class AdvancedComboboxView extends BorderPane {
	private ObjectProperty<ObservableList<CharacterObject>> characterList = new SimpleObjectProperty<>();
	private ObjectProperty<CharacterObject> selectedCharacter = new SimpleObjectProperty<>();

	public AdvancedComboboxView() {
		super();
		FXMLService.INSTANCE.loadView(this);
	}

	public final ObjectProperty<ObservableList<CharacterObject>> characterListProperty() {
		return this.characterList;
	}

	public final ObservableList<CharacterObject> getCharacterList() {
		return this.characterListProperty().get();
	}

	public final void setCharacterList(final ObservableList<CharacterObject> characterList) {
		this.characterListProperty().set(characterList);
	}

	public final ObjectProperty<CharacterObject> selectedCharacterProperty() {
		return this.selectedCharacter;
	}

	public final CharacterObject getSelectedCharacter() {
		return this.selectedCharacterProperty().get();
	}

	public final void setSelectedCharacter(final CharacterObject selectedCharacter) {
		this.selectedCharacterProperty().set(selectedCharacter);
	}
}

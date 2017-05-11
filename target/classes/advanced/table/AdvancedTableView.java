package advanced.table;

import com.preag.core.ui.service.FXMLService;

import helper.entities.CharacterObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class AdvancedTableView extends BorderPane {
	private ObjectProperty<ObservableList<CharacterObject>> allCharacters = new SimpleObjectProperty<>();
	private ObjectProperty<CharacterObject> selectedCharacter = new SimpleObjectProperty<>();

	public AdvancedTableView() {
		super();
		FXMLService.INSTANCE.loadView(this);
	}

	public final ObjectProperty<ObservableList<CharacterObject>> allCharactersProperty() {
		return this.allCharacters;
	}

	public final ObservableList<CharacterObject> getAllCharacters() {
		return this.allCharactersProperty().get();
	}

	public final void setAllCharacters(final ObservableList<CharacterObject> allCharacters) {
		this.allCharactersProperty().set(allCharacters);
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

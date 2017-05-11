package advanced.combobox;

import java.net.URL;
import java.util.ResourceBundle;

import helper.entities.CharacterObject;
import helper.utils.CharacterObjectConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdvancedComboboxController implements Initializable {

	@FXML
	ComboBox<CharacterObject> cmbCharacterSelection;
	@FXML
	Label lblSelectedCharacter;
	@FXML
	AdvancedComboboxView rootNode;
	@FXML
	ImageView imvwCharacter;

	private Image imgPlaceholderCharacter = new Image("/images/characterobject/CharPlaceholder.png");
	@FXML
	Label lblHitpoints;
	@FXML
	Label lblMana;
	@FXML
	Label lblAttack;
	@FXML
	Label lblDefence;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbCharacterSelection.itemsProperty().bindBidirectional(rootNode.characterListProperty());
		cmbCharacterSelection.setConverter(CharacterObjectConverter.characterNameConverter("No character"));

		rootNode.selectedCharacterProperty().bind(cmbCharacterSelection.getSelectionModel().selectedItemProperty());
		rootNode.selectedCharacterProperty().addListener((obs, oldVal, newVal) -> updateCharacterImageView(newVal));

		lblSelectedCharacter.textProperty().bindBidirectional(rootNode.selectedCharacterProperty(),
				CharacterObjectConverter.characterNameConverter("No character"));
		lblMana.textProperty().bindBidirectional(rootNode.selectedCharacterProperty(),
				CharacterObjectConverter.characterManaConverter());
		lblHitpoints.textProperty().bindBidirectional(rootNode.selectedCharacterProperty(),
				CharacterObjectConverter.characterHitpointsConverter());
		lblDefence.textProperty().bindBidirectional(rootNode.selectedCharacterProperty(),
				CharacterObjectConverter.characterDefenceConverter());
		lblAttack.textProperty().bindBidirectional(rootNode.selectedCharacterProperty(),
				CharacterObjectConverter.characterAttackConverter());

		imvwCharacter.setImage(imgPlaceholderCharacter);
	}

	private void updateCharacterImageView(CharacterObject newVal) {
		if (newVal != null) {
			imvwCharacter.setImage(newVal.getCharacterImage());
		} else {
			imvwCharacter.setImage(imgPlaceholderCharacter);
		}
	}

	@FXML
	public void onSelectNewCharacter() {
		rootNode.fireEvent(new AdvancedComboboxEvent(AdvancedComboboxEvent.SELECT_CHARACTER));
	}
}

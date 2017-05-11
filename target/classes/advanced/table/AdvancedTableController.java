package advanced.table;

import java.net.URL;
import java.util.ResourceBundle;

import helper.entities.CharacterObject;
import helper.utils.CharacterImageCellFactory;
import helper.utils.CharacterNameCellFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;

public class AdvancedTableController implements Initializable {

	@FXML
	AdvancedTableView rootNode;
	@FXML
	TableView<CharacterObject> tbvCharacterTable;
	@FXML
	TableColumn<CharacterObject, Image> tbcCharacterImage;
	@FXML
	TableColumn<CharacterObject, String> tbcCharacterName;
	@FXML
	TableColumn<CharacterObject, Double> tbcCharacterHp;
	@FXML
	TableColumn<CharacterObject, Double> tbcCharacterMp;
	@FXML
	TableColumn<CharacterObject, Double> tbcCharacterAtk;
	@FXML
	TableColumn<CharacterObject, Double> tbcCharacterDef;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tbvCharacterTable.itemsProperty().bindBidirectional(rootNode.allCharactersProperty());
		rootNode.selectedCharacterProperty().bind(tbvCharacterTable.getSelectionModel().selectedItemProperty());

		tbcCharacterHp.setCellValueFactory(param -> param.getValue().hitpointsProperty());
		tbcCharacterMp.setCellValueFactory(param -> param.getValue().manaProperty());
		tbcCharacterAtk.setCellValueFactory(param -> param.getValue().attackProperty());
		tbcCharacterDef.setCellValueFactory(param -> param.getValue().defenceProperty());

		tbcCharacterName.setCellFactory(new CharacterNameCellFactory());
		tbcCharacterName.setOnEditCommit((CellEditEvent<CharacterObject, String> param) -> finishEditColName(param));
		tbcCharacterName.setCellValueFactory(param -> param.getValue().nameProperty());

		tbcCharacterImage.setCellFactory(new CharacterImageCellFactory());
		tbcCharacterImage.setCellValueFactory(param -> param.getValue().characterImageProperty());
	}

	private void finishEditColName(CellEditEvent<CharacterObject, String> param) {
		CharacterObject selection = param.getTableView().getItems().get(param.getTablePosition().getRow());
		if (param.getNewValue() != null && !param.getNewValue().isEmpty()) {
			selection.setName(param.getNewValue());
		} else {
			selection.setName(param.getOldValue());
		}

	}
}

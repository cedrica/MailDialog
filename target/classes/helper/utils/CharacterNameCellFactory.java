package helper.utils;

import helper.entities.CharacterObject;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class CharacterNameCellFactory
		implements Callback<TableColumn<CharacterObject, String>, TableCell<CharacterObject, String>> {

	@Override
	public TableCell<CharacterObject, String> call(TableColumn<CharacterObject, String> param) {
		return new TableCellCallback();
	}

	private class TableCellCallback extends TableCell<CharacterObject, String> {
		private static final String NAME_REGEX = "[a-zA-Z]";
		private TextField textField;

		@Override
		public void cancelEdit() {
			super.cancelEdit();
			setText(getItem());
			setGraphic(null);
		}

		@Override
		public void startEdit() {
			if (!isEmpty()) {
				super.startEdit();
				createTextField();
				setText(null);
				setGraphic(textField);
				textField.selectAll();
			}
		}

		private void createTextField() {
			textField = new TextField(getString() + "");
			textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
			textField.setOnKeyTyped(evt -> checkInputKey(evt));
		}

		private void checkInputKey(KeyEvent evt) {
			String pressedKey = evt.getCharacter();
			if (pressedKey.equals("\r")) {
				commitEdit(textField.getText());
			} else if (pressedKey.matches(NAME_REGEX)) {

			} else {
				evt.consume();
			}
		}

		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			if (item == null || empty) {
				setText(null);
				setGraphic(null);
			} else {
				setText(item);
				setGraphic(null);
			}
		}

		private String getString() {
			return getItem() == null ? "" : getItem().toString();
		}
	}
}
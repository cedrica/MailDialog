package helper.utils;

import helper.entities.CharacterObject;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class CharacterImageCellFactory
		implements Callback<TableColumn<CharacterObject, Image>, TableCell<CharacterObject, Image>> {

	@Override
	public TableCell<CharacterObject, Image> call(TableColumn<CharacterObject, Image> param) {
		return new TableCellCallback();
	}

	private class TableCellCallback extends TableCell<CharacterObject, Image> {
		protected void updateItem(Image item, boolean empty) {
			super.updateItem(item, empty);
			if (item == null || empty) {
				setText(null);
				setGraphic(null);
			} else {
				setText(null);
				setGraphic(new ImageView(item));
			}
		}
	}
}

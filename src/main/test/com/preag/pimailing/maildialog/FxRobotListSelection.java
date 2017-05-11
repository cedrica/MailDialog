package com.preag.pimailing.maildialog;

import org.testfx.api.FxRobotInterface;

import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;

public interface FxRobotListSelection extends FxRobotInterface {
	default <T> void selectNextComboBoxItem(final ComboBox<T> combo) {
		clickOn(combo).type(KeyCode.DOWN).type(KeyCode.ENTER);
	}

	default <T> void selectGivenComboBoxItem(final ComboBox<T> combo, final T item) {
		final int index = combo.getItems().indexOf(item);
		final int indexSel = combo.getSelectionModel().getSelectedIndex();

//		if(index == -1)
//			fail("The item " + item + " is not in the combo box " + combo);

		clickOn(combo);

		if(index > indexSel)
			for(int i = indexSel; i < index; i++)
				type(KeyCode.DOWN);
		else if(index < indexSel)
			for(int i = indexSel; i > index; i--)
				type(KeyCode.UP);

		type(KeyCode.ENTER);
	}
}
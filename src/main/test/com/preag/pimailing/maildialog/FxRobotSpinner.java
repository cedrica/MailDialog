package com.preag.pimailing.maildialog;

import org.testfx.api.FxRobotInterface;

import javafx.scene.control.Spinner;

public interface FxRobotSpinner extends FxRobotInterface {
	default <T>void incrementSpinner(final Spinner<T> combo) {
		combo.getValueFactory().increment(1);
	}
	
	default <T>void decrementSpinner(final Spinner<T> combo) {
		combo.getValueFactory().decrement(1);
	}
}
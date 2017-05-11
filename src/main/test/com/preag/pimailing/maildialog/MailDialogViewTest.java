package com.preag.pimailing.maildialog;

import static org.junit.Assert.assertNotNull;

import org.apache.poi.util.TempFile;
import org.controlsfx.control.ToggleSwitch;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import com.preag.pimailing.maildialog.run.Main;
import com.preag.pimailing.maildialog.run.Template;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class MailDialogViewTest extends ApplicationTest
		implements FxRobotColourPicker, FxRobotListSelection, FxRobotSpinner {
	TextField subject;
	Button preview;
	Button loadAttachments;
	Button deleteAllAttachments;
	ToggleSwitch personalAdress;
	ComboBox<Template> template;

	FXMLLoader mainNode;

	@Override
	public void start(Stage stage) throws Exception {
		mainNode = new FXMLLoader(Main.class.getResource("/com/preag/pimailing/maildialog/MailDialogView.fxml"));
		mainNode.setRoot(new MailDialogView());
		mainNode.load();
		stage.setScene(new Scene(mainNode.getRoot()));
		stage.show();
		/*
		 * Do not forget to put the GUI in front of windows. Otherwise, the
		 * robots may interact with another window, the one in front of all the
		 * windows...
		 */
		stage.toFront();
	}

	/* Just a shortcut to retrieve widgets in the GUI. */
	public <T extends Node> T find(final String query) {
		/*
		 * TestFX provides many operations to retrieve elements from the loaded
		 * GUI.
		 */
		return lookup(query).query();
	}

	@Before
	public void setUp() {
		/* Just retrieving the tested widgets from the GUI. */
		subject = find("#tfSubject");
		preview = find("#btnShowPreview");
		loadAttachments = find("#btnAttachments");
	}

	@Test
	public void testInsertSubject() {
		clickOn(subject).type(KeyCode.END).type(KeyCode.BACK_SPACE, 10).type(KeyCode.NUMPAD0).type(KeyCode.X)
				.type(KeyCode.NUMPAD9).type(KeyCode.NUMPAD8).type(KeyCode.F).type(KeyCode.B).type(KeyCode.NUMPAD9)
				.type(KeyCode.NUMPAD9).type(KeyCode.F).type(KeyCode.F).type(KeyCode.ENTER);
		WaitForAsyncUtils.waitForFxEvents();

		// assertEquals("The binding between the text of the text field and the
		// selected colour of the color picker does not work",
		// text.getText(), picker.getValue().toString());
		clickOn(loadAttachments);
		clickOn(preview);
	}

//	@Test
//	public void testSelectTemplate() {
////		selectNextComboBoxItem(template);
////		WaitForAsyncUtils.waitForFxEvents();
//	}

	// @Test
	public void testWidgetsExist() {
		final String errMsg = "One of the widget cannot be retrieved anymore";
		assertNotNull(errMsg, subject);
		assertNotNull(errMsg, preview);
	}
}

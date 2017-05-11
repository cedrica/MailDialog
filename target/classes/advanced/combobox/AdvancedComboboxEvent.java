package advanced.combobox;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class AdvancedComboboxEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<AdvancedComboboxEvent> ANY = new EventType<>(ApplicationEvent.ANY, "AdvancedComboboxEvent");
	public static final EventType<AdvancedComboboxEvent> SELECT_CHARACTER = new EventType<>(ANY,"AdvancedComboboxEventSelectCharacter");
	// @formatter:on

	public AdvancedComboboxEvent(EventType<? extends Event> eventType) {
		super(eventType);

	}

	public AdvancedComboboxEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

	}

}

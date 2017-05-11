package basic.datepicker;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class BasicDatePickerEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<BasicDatePickerEvent> ANY = new EventType<>(ApplicationEvent.ANY,"BasicDatePickerEvent");
	public static final EventType<BasicDatePickerEvent> SELET_BIRTHDAY = new EventType<>(ANY,"BasicDatePickerEventSelectBirthday");
	// @formatter:on

	public BasicDatePickerEvent(EventType<? extends Event> eventType) {
		super(eventType);

	}

	public BasicDatePickerEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

	}
}

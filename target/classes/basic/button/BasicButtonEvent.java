package basic.button;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class BasicButtonEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<BasicButtonEvent> ANY = new EventType<>(ApplicationEvent.ANY, "BasicButtonEvent");
	public static final EventType<BasicButtonEvent> LOGIN = new EventType<>(ANY, "BasicButtonEventLogin");
	// @formatter:on

	public BasicButtonEvent(EventType<? extends Event> eventType) {
		super(eventType);

	}

	public BasicButtonEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

	}
}

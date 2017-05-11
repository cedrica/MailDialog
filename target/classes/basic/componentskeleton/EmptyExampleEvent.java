package basic.componentskeleton;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class EmptyExampleEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<EmptyExampleEvent> ANY = new EventType<>(ApplicationEvent.ANY, "EmptyExampleEvent");
	// @formatter:on

	public EmptyExampleEvent(EventType<? extends Event> eventType) {
		super(eventType);

	}

	public EmptyExampleEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

	}
}

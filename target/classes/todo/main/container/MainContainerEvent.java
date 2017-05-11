package todo.main.container;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class MainContainerEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<MainContainerEvent> ANY = new EventType<>(ApplicationEvent.ANY, "MainContainerEvent");
	public static final EventType<MainContainerEvent> SETTINGS = new EventType<>(ANY,"MainContainerEventSettings");
	// @formatter:on

	public MainContainerEvent(EventType<? extends Event> eventType) {
		super(eventType);

	}

	public MainContainerEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

	}

}

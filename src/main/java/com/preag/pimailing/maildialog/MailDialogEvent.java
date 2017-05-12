package com.preag.pimailing.maildialog;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class MailDialogEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	// @formatter:off
	public static final EventType<MailDialogEvent> ANY = new EventType<>(ApplicationEvent.ANY, "MailDialogEvent");
	public static final EventType<MailDialogEvent> PREVIEW = new EventType<>(ANY, "MailDialogEventPreview");
	public static final EventType<MailDialogEvent> RECEIVER = new EventType<>(ANY, "MailDialogEventReceiver");
	public static final EventType<MailDialogEvent> TEMPLATE = new EventType<>(ANY, "MailDialogEventTemplate");
	// @formatter:on

	public MailDialogEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}

	public MailDialogEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);
	}
}

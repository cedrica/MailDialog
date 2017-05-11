package com.preag.pimailing.maildialog.advancedtextfield;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventType;

public class AdvancedTextFieldEvent extends Event{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final EventType<AdvancedTextFieldEvent> SPEAK_TO_MY_SELF = new EventType<>(ANY,"SpeakToMySelf");
	private ObservableList<String> attachments;
	
	public AdvancedTextFieldEvent(EventType<? extends Event> eventType, ObservableList<String> newList) {
		super(eventType);
		this.attachments = newList;
	}

	public ObservableList<String> getAttachments() {
		return attachments;
	}
	
}

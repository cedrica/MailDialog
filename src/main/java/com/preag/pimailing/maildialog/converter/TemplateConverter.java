package com.preag.pimailing.maildialog.converter;

import com.preag.pimailing.maildialog.run.Template;

import javafx.util.StringConverter;

public class TemplateConverter extends StringConverter<Template> {

	@Override
	public String toString(Template template) {
		return template.getCaption();
	}

	@Override
	public Template fromString(String string) {
		return null;
	}

}

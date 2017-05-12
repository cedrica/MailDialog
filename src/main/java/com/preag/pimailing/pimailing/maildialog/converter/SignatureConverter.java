package com.preag.pimailing.maildialog.converter;

import com.preag.pimailing.maildialog.run.Signature;

import javafx.util.StringConverter;

public class SignatureConverter extends StringConverter<Signature> {


	@Override
	public String toString(Signature signature) {
		return signature.getSignatureName();
	}

	@Override
	public Signature fromString(String string) {
		return null;
	}

}

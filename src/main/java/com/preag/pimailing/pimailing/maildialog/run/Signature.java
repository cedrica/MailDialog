package com.preag.pimailing.maildialog.run;

import java.io.File;
import java.util.List;

public class Signature {
	private String signatureName;
	private String signatureHTML;
	private List<File> signatureLogo;

	public String getSignatureName() {
		return signatureName;
	}

	public void setSignatureName(String signatureName) {
		this.signatureName = signatureName;
	}

	public String getSignatureHTML() {
		return signatureHTML;
	}

	public void setSignatureHTML(String signatureHTML) {
		this.signatureHTML = signatureHTML;
	}

	public List<File> getSignatureLogo() {
		return signatureLogo;
	}

	public void setSignatureLogo(List<File> signatureLogo) {
		this.signatureLogo = signatureLogo;
	}

	@Override
	public String toString() {
		return this.signatureName;
	}

}

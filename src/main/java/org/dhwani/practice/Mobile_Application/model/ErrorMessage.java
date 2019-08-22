package org.dhwani.practice.Mobile_Application.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private int errorCode;
	private String message;
	private String documentation;

	public ErrorMessage() {
		super();
	}
	public ErrorMessage(int errorCode, String message, String documentation) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.documentation = documentation;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}

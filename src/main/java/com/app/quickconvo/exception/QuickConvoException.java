package com.app.quickconvo.exception;

public class QuickConvoException extends RuntimeException {

	private final String message;

	public QuickConvoException(String msg) {
		super();
		this.message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

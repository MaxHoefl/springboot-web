package com.example.demo.exception;

public class DuplicateResourceException extends RuntimeException {
	private static final long serialVersionUID = -7903696769324013462L;

	public DuplicateResourceException(String message) {
		super(message);
	}
}

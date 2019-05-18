package com.khalanirek.exception.notfound;

public class PhaseNotFoundException extends Exception {
	public PhaseNotFoundException(long phaseId) {
		super("Phase with Id: " + phaseId + " not found");
	}
}

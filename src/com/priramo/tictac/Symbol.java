package com.priramo.tictac;

public enum Symbol {
	CROSS(StringConstants.X),
	CIRCLE(StringConstants.O),
	EMPTY(StringConstants.EMPTY);
	
	private String value;
	
	private Symbol(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}

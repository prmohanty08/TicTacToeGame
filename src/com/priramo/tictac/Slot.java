package com.priramo.tictac;

public class Slot {
	private Symbol symbol;
	private boolean isFilled;
	private int rowIndex;
	private int colIndex;

	public Slot(int theRowIndex, int theColIndex) {
		this.rowIndex = theRowIndex;
		this.colIndex = theColIndex;
	}

	public boolean setSymbol(Symbol newSymbol) {
		if (!this.isFilled) {
			this.symbol = newSymbol;
			this.isFilled = true;
		} else {
			System.err.println("Invalid attempt. Please try again.");
		}
		return this.isFilled;
	}

	public Symbol getSymbol() {
		return this.symbol == null ? Symbol.EMPTY : this.symbol;
	}

	public String toString() {
		return getSymbol().toString();
	}

	public void clear() {
		this.symbol = null;
	}

	public String getPosition() {
		return "[" + this.rowIndex + ", " + this.colIndex + "]";
	}
}

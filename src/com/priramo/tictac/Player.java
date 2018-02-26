package com.priramo.tictac;

public class Player {
	private String name;
	private Symbol symbol;
	private boolean isNext;

	public Player(String newName, Symbol newSymbol) {
		this.name = newName;
		this.symbol = newSymbol;
		System.out.println(this.name + " joined the game with symbol: " + this.symbol);
	}

	public String getName() {
		return this.name;
	}

	public void setNext(boolean isNextVal) {
		this.isNext = isNextVal;
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public boolean mark(Board theBoard) {
		
		if (this.isNext) {
			int rowIndex, colIndex;
			do {
				System.out.print(this.name + ", enter your move (row[1-" + theBoard.getRows() + "] column[1-" + theBoard.getCols() + "]): ");
				rowIndex = theBoard.getConsole().nextInt() - 1;
				colIndex = theBoard.getConsole().nextInt() - 1;
			} while (!theBoard.fillSlot(this.symbol, rowIndex, colIndex));

			this.isNext = false;
			return !this.isNext;
		}
		return this.isNext;
	}
}

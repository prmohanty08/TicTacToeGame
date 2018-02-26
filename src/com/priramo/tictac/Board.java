package com.priramo.tictac;

import static com.priramo.tictac.StringConstants.*;

import java.util.Scanner;

public class Board implements Cloneable {
	private int rows = 3, cols = 3;
	private Slot[][] slots;
	private int totalAvailableSlots;
	private String  status = OPEN;
	private Scanner console = new Scanner(System.in);

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		init();
	}
	
	private void init() {
		this.slots = new Slot[this.rows][this.cols];
		for(int row = 0; row < this.rows; row++) {
			for(int col = 0; col < this.cols; col++) {
				this.slots[row][col] = new Slot(row, col);
			}
		}
		this.totalAvailableSlots = this.rows * this.cols;
	}

	public void reset() {
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.cols; col++) {
				this.slots[row][col].clear();
			}
		}
	}
	
	public boolean fillSlot(Symbol newSymbol, int rowIndex, int colIndex) {
		if (slots[rowIndex][colIndex].setSymbol(newSymbol)) {
			this.totalAvailableSlots--;
			if(hasPlayerWon(newSymbol, rowIndex, colIndex)) {
				this.status = GAME_OVER;
			} else if (this.totalAvailableSlots == 0) {
				this.status = GAME_DRAWN;
			}
			return true;
		} else {
			return false;
		}
	}
	
	private boolean hasPlayerWon(Symbol theSymbol, int currentRow, int currentCol) {
		return (slots[currentRow][0].getSymbol() == theSymbol // 3-in-the-row
				&& slots[currentRow][1].getSymbol() == theSymbol 
				&& slots[currentRow][2].getSymbol() == theSymbol
				|| slots[0][currentCol].getSymbol() == theSymbol // 3-in-the-column
				&& slots[1][currentCol].getSymbol() == theSymbol
				&& slots[2][currentCol].getSymbol() == theSymbol
				|| currentRow == currentCol // 3-in-the-diagonal
				&& slots[0][0].getSymbol() == theSymbol 
				&& slots[1][1].getSymbol() == theSymbol
				&& slots[2][2].getSymbol() == theSymbol
				|| currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
				&& slots[0][2].getSymbol() == theSymbol 
				&& slots[1][1].getSymbol() == theSymbol
				&& slots[2][0].getSymbol() == theSymbol);
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getRows() {
		return this.rows;
	}

	public int getCols() {
		return this.cols;
	}

	public Scanner getConsole() {
		return this.console;
	}
	
	public String toString() {
		StringBuilder bsb = new StringBuilder();
		for (int row = 0; row < this.rows; ++row) {
			for (int col = 0; col < this.cols; ++col) {
				bsb.append(EMPTY).append(this.slots[row][col]).append(EMPTY);
				if (col != this.cols - 1) {
					bsb.append(PIPELINE);
				}
			}
			bsb.append(NEW_LINE);
			if (row != this.rows - 1) {
				bsb.append(HORIZONTAL_PARTITION);
				bsb.append(NEW_LINE);
			}
		}
		bsb.append(NEW_LINE);
		return bsb.toString();
	}
}

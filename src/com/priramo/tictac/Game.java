package com.priramo.tictac;

import static com.priramo.tictac.StringConstants.*;

public class Game {

	public static void main(String[] args) {
		System.out.println("------------------------------------");
		System.out.println("Welcome to the Tic-Tac-Toe Game");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("MODE: 2 Player Console");
		System.out.println("------------------------------------");
		
		Board board = new Board(3, 3);
		System.out.println("Enter the first player name:");
		String playerOneName = board.getConsole().next();
		Player playerOne = new Player(playerOneName, Symbol.CROSS);
		System.out.println("Enter the second player name:");
		String playerTwoName = board.getConsole().next();
		Player playerTwo = new Player(playerTwoName, Symbol.CIRCLE);
		
		playerOne.setNext(true);
		while (board.getStatus().equals(OPEN)) {
			if (playerOne.mark(board)) {
				Player nextPlayer = playerTwo;
				playerTwo = playerOne;
				playerOne = nextPlayer;
				playerOne.setNext(true);
				System.out.println(board);
			}
		}
		if (board.getStatus().equals(GAME_OVER)) {
			System.out.println("------------------------------------");
			System.out.println("Winner : " + playerTwo.getName());
			System.out.println("------------------------------------");
		} else if (board.getStatus().equals(GAME_DRAWN)) {
			System.out.println("------------------------------------");
			System.out.println("            GAME DRAWN ");
			System.out.println("------------------------------------");
		}
		
		System.out.println(board);
	}
}

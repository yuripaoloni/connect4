/**
 * 
 */
package it.unicam.cs.pa.connect4.view;

import java.io.BufferedReader;


import java.io.PrintStream;

import it.unicam.cs.pa.connect4.field.Field;
import it.unicam.cs.pa.connect4.field.State;

/**
 * Responsibility: This class provides the methods used to print basic information about the game, like table printing and moves notifying.
 *
 * @author Paoloni
 *
 */

public class ConsoleGameView implements GameView {

	/**
	 * The character printed in case of empty cell.
	 */
	private static final char EMPTY_CHAR = '-';
	
	/**
	 * The character printed in case of cell containing circle.
	 */
	private static final char CIRCLE_CHAR = 'O';
	
	/**
	 * The character printed in case of cell containing cross.
	 */
	private static final char CROSS_CHAR = 'X';
	
	private PrintStream output;
	private BufferedReader input;
	
	/**
	 * the current game field.
	 */
	private Field field;
	
	public ConsoleGameView(PrintStream output, BufferedReader input, Field field) {
		this.field = field;
		this.input = input;
		this.output = output;
	}
	
	@Override
	public void display() {
		output.println("\n| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n");
		for (int i = 0; i < field.getHeight(); i++) {
			for (int j = 0; j < field.getWidth(); j++) {
				output.print("| " + charOf(field.getBoard()[i][j].getCellState()) + " ");
			}
			output.println("|");
		}
		output.println("\n*****************************\n");	
	}
		
	/**
	 * Used for match the <code>enum</code> type with the correspondent char.
	 * 
	 * @param state the <code>enum</code> to be matched
	 * @return the correspondent char to the <code>enum</code> value
	 */
	private char charOf(State state) {
		switch (state) {
		case CIRCLE:
			return CIRCLE_CHAR;
		case CROSS:
			return CROSS_CHAR;
		case EMPTY:
			return EMPTY_CHAR;
		}
		return ' ';
	}
	
	@Override
	public void lastMoveInfo(int playerIndex, int column, int row) {
		output.println("Player " + playerIndex + " placed in column: " + (column+1) + ", row: " + (row+1));
		display();
	}

	@Override
	public void init() {
		output.println("Ready for a new match!");
		display();
	}
}

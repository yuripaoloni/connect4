/**
 * 
 */
package it.unicam.cs.pa.connect4.view;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintStream;

import it.unicam.cs.pa.connect4.field.Field;

/**
 * Responsibility : This is the view used by the players in order to place checker and do all the needed control about insertion.
 * 
 * @author Paoloni
 *
 */
public class ConsolePlayerView implements PlayerView{
		
	private PrintStream output;
	private BufferedReader input;
	
	/**
	 * the current game field.
	 */
	private Field field;
	
	/**
	 * the player id.
	 */
	private String playerId;

	public ConsolePlayerView(String playerId, PrintStream output, BufferedReader input, Field field) {
		this.field = field;
		this.playerId = playerId;
		this.input = input;
		this.output = output;
	}
	
	@Override
	public int place() throws IOException {
		return this.inputLocation();
	}

	/**
	 * Asks to the "interactive" players to inputs a column from the keyboard.
	 * 
	 * @return the column inserted from the keyboard if it's valid.
	 * @throws IOException
	 */
	private int inputLocation() throws IOException {
		println("select a column from 1 to 7.");
		while(true) {
			int column = this.inputInteger(1, 7) - 1;
			if(!field.isColumnFull(column)) return column;
			println("the selected column is full, pick another one.");
		}
	}
	
	/**
	 * Utility method used to print strings that begins with the id of the player.
	 * @param string
	 */
	private void println(String string) {
		output.println(playerId + " " + string);
	}

	/**
	 * Gets the value inserted from the keyboard and check if it's included between <code>limit1</code> and <code>limit2</code>.
	 * @param limit1 the left limit for the value.
	 * @param limit2 the right limit for the value.
	 * @return the number inputs from the keyboard if it fulfills the requirement.
	 * @throws IOException
	 */
	private int inputInteger(int limit1, int limit2) throws IOException {
		while (true) {
			String str = input.readLine();
			try {
				int i = Integer.parseInt(str);
				if(i>=limit1 && i<=limit2) {
					return i;
				}
			} catch (NumberFormatException e) {	
				
			}
			println("Please insert an integer number between " + limit1 + " and " + limit2);
		}
	}
}

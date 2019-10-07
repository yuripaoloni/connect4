/**
 * 
 */
package it.unicam.cs.pa.connect4.players;

import java.io.IOException;


import it.unicam.cs.pa.connect4.field.FieldCoordinator;
import it.unicam.cs.pa.connect4.field.State;

/**
 * Responsibility : This class manage the informations about the <code>BotPlayer</code>. This is a computer player that places checkers in a random way.
 * 
 * @author Paoloni
 */
public class BotPlayer extends FieldCoordinator implements Player {
	
	/**
	 * the color used by this player.
	 */
	private State color;
	
	/**
	 * the index of this player.
	 */
	private int index;
			
	public BotPlayer(int index, State color) {
		this.index = index;
		this.color = color;
	}
	
	@Override
	public int place() throws IOException {
		int column = this.getBotChoice();
		this.setFieldStatus(column, color); 
		this.setMyMoveFieldStatus(this.getFieldLastMove());
		return column;
	}
		
	/**
	 * It gets the column in which insert the new checker, more precisely it is randomly selected.
	 * 
	 * @return the column in which this player wants to place a new checker.
	 */
	private int getBotChoice() {
		int column = 0;
		do {
			column = (int) (Math.random() * 7);
		} while(this.getField().isColumnFull(column));
		return column;
	}
	
	@Override
	public void updateLastOpponentMove(int column, int row, State color) {
		this.setFieldStatus(column, color);
		this.setOpponentMoveFieldStatus(column, row, color);
	}
				
	@Override
	public int getIndex() {
		return index;
	}
	
	@Override
	public State getColor() {
		return this.color;
	}
	
}

/**
 * 
 */
package it.unicam.cs.pa.connect4.players;

import java.io.IOException;


import it.unicam.cs.pa.connect4.field.FieldCoordinator;
import it.unicam.cs.pa.connect4.field.State;
/**
 * Responsibility :  This class manage the informations about the <code>StrategicPlayer</code>. 
 * This is a computer player that places checkers in the same column of the opponent.
 * 
 * @author Paoloni
 *
 */
public class StrategicPlayer extends FieldCoordinator implements Player {
	
	/**
	 * the color used by this player.
	 */
	private State color;
	
	/**
	 * the index of this player.
	 */
	private int index;
			
	public StrategicPlayer(int index, State color) {
		this.index = index;
		this.color = color;
	}
		
	@Override
	public int place() throws IOException {
		int column = this.getStrategicPlayerChoice();
		this.setFieldStatus(column, color); 
		this.setMyMoveFieldStatus(this.getFieldLastMove());
		return column;
	}
	
	/**
	 * It gets the column thanks to the abstract class <code>FieldCoordinator</code> in which all the moves are stored. 
	 * Gets the last opponent move and place in the some column, if the column is full place in next column. 
	 * If he's the first to place, select a random column.
	 * 
	 * @return the column in which this player wants to place a new checker.
	 */
	private int getStrategicPlayerChoice() {
		int column = this.getOpponentLastMove().getColumn();
		if(column == -1) return (int) (Math.random() * 7);
		while(this.getField().isColumnFull(column)) {
			if(column == 7) column = 0;
			column++;
		}
		return column;
	}
	
	@Override
	public void updateLastOpponentMove(int column, int row, State color) {
		this.setFieldStatus(column, color);
		this.setOpponentMoveFieldStatus(column, row, color);
	}
			
	@Override
	public State getColor() {
		return this.color;
	}
	
	@Override
	public int getIndex() {
		return this.index;
	}
}

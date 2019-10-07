/**
 * 
 */
package it.unicam.cs.pa.connect4.field;

/**
 * Responsibility : This class stores the information about the last move. It is used in the winning condition algorithm for starts checking at
 * the row and column where the last checker was played, and also for checking only one color.
 * 
 * @author Paoloni
 */

public class Move {
	
	/**
	 * the row of this move.
	 */
	private int row;
	
	/**
	 * the column of this move.
	 */
	private int column;
	
	/**
	 * the symbol of this move.
	 */
	private State state;
		
	/**
	 * used to initializing the <code>lastMove</code>
	 */
	public Move() {
		this.row = -1;
		this.column = -1;
		this.state = State.EMPTY;
	}
	
	/**
	 * used to update the <code>lastMove</code>
	 * @param row the new row of the <code>lastMove</code>
	 * @param column the new column of the <code>lastMove</code>
	 * @param state the new state of the <code>lastMove</code>
	 */
	public Move(int row, int column, State state) {
		this.row = row;
		this.column = column;
		this.state = state;
	}
		
	/**
	 * 
	 * @return the row of the last move
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @param row set the row of the last move
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * 
	 * @return the column of the last move
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * 
	 * @param column set the column of the last move
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * 
	 * @return the symbol played in the last move
	 */
	public State getState() {
		return state;
	}

	/**
	 * 
	 * @param state set the state of the last move
	 */
	public void setState(State state) {
		this.state = state;
	}
}

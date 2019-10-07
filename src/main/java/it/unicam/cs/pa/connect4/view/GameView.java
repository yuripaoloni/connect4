/**
 * 
 */
package it.unicam.cs.pa.connect4.view;

/**
 * Responsibility : Defines the features provided by a view for the Connect Four game.
 * 
 * @author Paoloni
 *
 */
public interface GameView {
	
	
	/**
	 * Prints the current board with the state of each cells.
	 */
	void display();
	
	/**
	 * Prints information about the last move did in the current match.
	 * @param playerIndex the index of the player
	 * @param column the column of the last move.
	 * @param row the row of the last move.
	 */
	void lastMoveInfo(int playerIndex, int column, int row);
	
	/**
	 * Prints the initial information before starting a new match.
	 */
	void init();
	
	
	
}

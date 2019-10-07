/**
 * 
 */
package it.unicam.cs.pa.connect4.players;

import java.io.IOException;


import it.unicam.cs.pa.connect4.field.State;

/**
 * Responsibility : Interface used for providing some useful methods to the player's classes. Its most important goal is to provides a common type for
 * the different players in order to make possible to use an array of <code>Player</code>.
 * 
 * @author Paoloni
 */
public interface Player {

	/**
	 * Returns the checker in which the player wants to place the new checker, 
	 * each type of player selects the column in different way.
	 * 
	 * @return the column in which place the new checker.
	 * @throws IOException
	 */
	int place() throws IOException;

	/**
	 * 
	 * @return the color used by this player.
	 */
	State getColor();
	
	/**
	 * 
	 * @return the index of this player.
	 */
	int getIndex();
		
	/**
	 * Update the data about the last opponent move
	 * 
	 * @param lastOpponentMove the last move of the opponent.
	 */
	void updateLastOpponentMove(int column, int row, State color);
}

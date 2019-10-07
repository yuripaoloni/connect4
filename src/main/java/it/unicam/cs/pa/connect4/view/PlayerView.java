/**
 * 
 */
package it.unicam.cs.pa.connect4.view;

import java.io.IOException;

/**
 * Responsibility: Defines the basic features used by an interactive player to interact.
 * 
 * @author Paoloni
 *
 */
public interface PlayerView {
	
	/**
	 * Asks user in which column wants to place a new checker.
	 * 
	 * @return the column in which the player wants to place a new checker.
	 * @throws IOException
	 */
	public int place() throws IOException;

}

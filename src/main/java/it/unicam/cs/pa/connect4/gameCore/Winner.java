/**
 * 
 */
package it.unicam.cs.pa.connect4.gameCore;

/**
 * Responsibility : This class increment the number of win and print the correct statement in case of win.
 * 
 * @author Paoloni
 *
 */
public class Winner implements GameResult{
	
	private int index;
	
	
	public Winner(int index) {
		this.index = index;
	}

	/**
	 * @return the statement printed in case of win.
	 */
	public String toString() {
		return "Player" + index + " has won the game";
	}
	
}

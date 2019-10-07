/**
 * 
 */
package it.unicam.cs.pa.connect4.gameCore;

/**
 * Responsibility : This class prints the correct statement in case of draw.
 * 
 * @author Paoloni
 *
 */
public class Draw implements GameResult{
	
	/**
	 * @return the statement printed in case of draw.
	 */
	public String toString() {
		return "It's a draw.";
	}
	
}

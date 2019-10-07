/**
 * 
 */
package it.unicam.cs.pa.connect4.players;

import java.io.IOException;



import it.unicam.cs.pa.connect4.field.State;
import it.unicam.cs.pa.connect4.view.PlayerView;

/**
 * Responsibility : This class manage the informations about the InteractivePlayer. 
 * This is an interactive player able to places checkers by inserting the selected column from the keyboard. 
 * 
 * @author Paoloni
 */

public class InteractivePlayer implements Player {

	/**
	 * the player view.
	 */
	private PlayerView view;
	
	/**
	 * the color used by this player.
	 */
	private State color;
		
	/**
	 * the index of this player.
	 */
	private int index;

	public InteractivePlayer(int index, State color, PlayerView view) {
		this.index = index;
		this.view = view;
		this.color = color;
	}
	
	@Override
	public int place() throws IOException {
		return view.place();
	}
		
	@Override
	public int getIndex() {
		return index;
	}
	
	@Override
	public State getColor() {
		return color;
	}
	
	@Override
	public void updateLastOpponentMove(int column, int row, State color) {
	}
}

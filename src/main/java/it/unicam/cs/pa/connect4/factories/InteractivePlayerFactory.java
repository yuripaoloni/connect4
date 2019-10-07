/**
 * 
 */
package it.unicam.cs.pa.connect4.factories;

import it.unicam.cs.pa.connect4.field.State;


import it.unicam.cs.pa.connect4.players.InteractivePlayer;
import it.unicam.cs.pa.connect4.players.Player;
import it.unicam.cs.pa.connect4.view.PlayerView;

/**
 * Responsibility : This class provides the method used to create the object of the type <code>InteractivePlayer</code>. 
 * Implements the interface PlayerFactory.
 * 
 * @author Paoloni
 *
 */
public class InteractivePlayerFactory implements PlayerFactory {

	@Override
	public Player createPlayer(int index, PlayerView view, State color) {
		return new InteractivePlayer(index, color, view);
	}

}

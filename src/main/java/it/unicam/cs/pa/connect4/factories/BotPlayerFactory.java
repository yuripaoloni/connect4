/**
 * 
 */
package it.unicam.cs.pa.connect4.factories;

import it.unicam.cs.pa.connect4.field.State;



import it.unicam.cs.pa.connect4.players.BotPlayer;
import it.unicam.cs.pa.connect4.players.Player;
import it.unicam.cs.pa.connect4.view.PlayerView;

/**
 * Responsibility : This class provides the method used to create the object of the type <code>BotPlayer</code>. 
 * Implements the interface PlayerFactory.
 * 
 * @author Paoloni
 *
 */
public class BotPlayerFactory implements PlayerFactory{

	@Override
	public Player createPlayer(int index, PlayerView view, State color) {
		return new BotPlayer(index, color);
	}

}

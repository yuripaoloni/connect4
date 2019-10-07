/**
 * 
 */
package it.unicam.cs.pa.connect4.factories;

import it.unicam.cs.pa.connect4.field.State;


import it.unicam.cs.pa.connect4.players.Player;
import it.unicam.cs.pa.connect4.players.StrategicPlayer;
import it.unicam.cs.pa.connect4.view.PlayerView;

/**
 * Responsibility : This class provides the method used to create the object of the type <code>StrategicPlayer</code>. 
 * Implements the interface PlayerFactory. 
 * 
 * @author Paoloni
 *
 */
public class StrategicPlayerFactory implements PlayerFactory {

	@Override
	public Player createPlayer(int index, PlayerView view, State color) {
		return new StrategicPlayer(index, color);
	}

}

/**
 * 
 */
package it.unicam.cs.pa.connect4.factories;

import it.unicam.cs.pa.connect4.field.State;


import it.unicam.cs.pa.connect4.players.Player;
import it.unicam.cs.pa.connect4.view.PlayerView;

/**
 * Responsibility: This interface provide the method used to create the correct type of player. 
 * 
 * @author Paoloni
 *
 */

@FunctionalInterface
public interface PlayerFactory {

	/**
	 * Return the new <code>Player</code> of the correct type.
	 * 
	 * @param index the index of the new player
	 * @param view the player view
	 * @param color the color that the new player will use
	 * @return <code>Player</code> the new player
	 */
	Player createPlayer(int index, PlayerView view, State color);

}

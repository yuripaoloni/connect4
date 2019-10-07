/**
 * 
 */
package it.unicam.cs.pa.connect4.gameCore;

import java.io.IOException;


import it.unicam.cs.pa.connect4.field.Field;
import it.unicam.cs.pa.connect4.players.Player;
import it.unicam.cs.pa.connect4.view.GameView;

/**
 * Responsibility : This class acts as the Model of the MVC pattern. It provides the methods to access the application's data. 
 * The class <code>GameHandler</code>, as the name implies, handles the turns and establishes the outcome of the game.
 * 
 * @author Paoloni
 *
 */
public class GameCoordinator {
	
	/**
	 * array containing the players of the game.
	 */
	private Player[] players;
	
	/**
	 * the current game field.
	 */
	private Field field;
	
	/**
	 * the console game view.
	 */
	private GameView view;
	
	/**
	 * counter of turns.
	 */
	private int count;
	
	public GameCoordinator(GameView view, Field field, Player player1, Player player2) {
		this.field = field;
		this.players = new Player[]{player1, player2};
		this.view = view;
		this.count = 0;		
	}
	
	/**
	 * Handles the match and stop when the winning condition is reached of the board is full.
	 * 
	 * @return the game outcome of type <code>GameResult</code>.
	 * @throws IOException
	 */
	public GameResult play() throws IOException {
		view.init();
		while(true) {
			manageTurn();
			int result = field.isGameOver(field.getLastMove());
			if(result == 1) return new Winner(players[current()].getIndex());
			if(result == 2) return new Draw();
			count = opponent();
		}
	}
	
	/**
	 * Obtains from the current player the column in which insert the new checker and then notify the other player about the last move.
	 * @throws IOException
	 */
	private void manageTurn() throws IOException {
		int column = players[current()].place();
		field.placeChecker(column, players[current()].getColor());
		players[opponent()].updateLastOpponentMove(field.getLastMove().getColumn(), field.getLastMove().getRow(), field.getLastMove().getState());
		view.lastMoveInfo(players[current()].getIndex(), field.getLastMove().getColumn(), field.getLastMove().getRow());
	}
		
	/**
	 * 
	 * @return the opponent index.
	 */
	private int opponent() {
		return (count+1)%2;
	}
	
	/**
	 * 
	 * @return the current players index.
	 */
	private int current() {
		return count;
	}
}
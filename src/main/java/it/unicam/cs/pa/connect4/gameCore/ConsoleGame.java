/**
 * 
 */
package it.unicam.cs.pa.connect4.gameCore;

import java.io.BufferedReader;




import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import it.unicam.cs.pa.connect4.factories.PlayerFactory;
import it.unicam.cs.pa.connect4.factories.PlayerRegistry;
import it.unicam.cs.pa.connect4.field.Field;
import it.unicam.cs.pa.connect4.field.GameField;
import it.unicam.cs.pa.connect4.field.State;
import it.unicam.cs.pa.connect4.view.ConsoleGameView;
import it.unicam.cs.pa.connect4.view.ConsolePlayerView;

/**
 * Responsibility : This class acts as the Controller of the MVC pattern. This class get the user's commands from the View and applies them 
 * changing the state of the other two component (View and Model). It also carry the main used to launch the application. Specifically this class 
 * starts a new game and at the end of each match asks the user if wants to play another one.
 * 
 * @author Paoloni
 *
 */
public class ConsoleGame {

	private PrintStream output;	
	private BufferedReader input;
	
	/**
	 * the factory of player1.
	 */
	private PlayerFactory playerFactory1;
	
	/**
	 * the factory of player2.
	 */
	private PlayerFactory playerFactory2;
		
	public ConsoleGame(PlayerFactory playerFactory1, PlayerFactory playerFactory2) {
		this(new BufferedReader(new InputStreamReader(System.in)),System.out,playerFactory1,playerFactory2);
	}
	
	private ConsoleGame(BufferedReader input, 
			PrintStream output,
			PlayerFactory playerFactory1,
			PlayerFactory playerFactory2) {
		this.input = input;
		this.output = output;
		this.playerFactory1 = playerFactory1;
		this.playerFactory2 = playerFactory2;  
	}
	
	public static void main(String[] argv) throws IOException {
		if (argv.length!=2) {
			System.err.println("Use : "
					+ "\n\t- <interactive> for the interactive player "
					+ "\n\t- <bot> for the bot player"
					+ "\n\t- <strategic> for the strategic player.");
		} else {
			System.out.println("Welcome in the Connect Four game!\n");
			new ConsoleGame(PlayerRegistry.getInstance().getPlayer(argv[0]), PlayerRegistry.getInstance().getPlayer(argv[1])).start();			
		}
	}
	
	/**
	 * Starts a new game initializing all the data that concern it.
	 * 
	 * @throws IOException
	 */
	private void start() throws IOException {
		do {
			Field field = new GameField();
			GameCoordinator gameCoordinator = new GameCoordinator(
					new ConsoleGameView(output, input, field),
					field,
					playerFactory1.createPlayer(1, new ConsolePlayerView("Player1", output, input, field), State.CIRCLE),
					playerFactory2.createPlayer(2, new ConsolePlayerView("Player2", output, input, field), State.CROSS)
			);
			output.println(gameCoordinator.play());  
		}while(matchAgain());
	}
	
	/**
	 * Asks the user if wants to play another match or quit the game.
	 * @return <code>true</code> to play a new match, <code>false</code> otherwise.
	 * @throws IOException
	 */
	private boolean matchAgain() throws IOException {
		output.println("Play again? (Y/N)");
		while (true) {
			String str = input.readLine();
			if (str.equals("N")) {
				output.println("Goodbye...");
				return false;
			}
			if (str.equals("Y")) {
				return true;
			}
			output.println("Insert Y or N!");
		}
	}
	
}
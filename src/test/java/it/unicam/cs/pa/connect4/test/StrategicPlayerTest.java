/**
 * 
 */
package it.unicam.cs.pa.connect4.test;

import static org.junit.Assert.assertEquals;


import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.connect4.field.GameField;
import it.unicam.cs.pa.connect4.field.State;
import it.unicam.cs.pa.connect4.players.StrategicPlayer;

/**
 * @author Paoloni
 *
 */
public class StrategicPlayerTest {
	
	@Test
	public void addCheckerTest() throws IOException {
		GameField g = new GameField();
		StrategicPlayer p = new StrategicPlayer(1, State.CROSS);
		g.placeChecker(p.place(), State.CROSS);
		assertEquals(g.getBoard()[g.getLastMove().getRow()][g.getLastMove().getColumn()].getCellState(), State.CROSS);
	}

}

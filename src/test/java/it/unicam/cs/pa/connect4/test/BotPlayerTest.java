/**
 * 
 */
package it.unicam.cs.pa.connect4.test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.connect4.field.GameField;
import it.unicam.cs.pa.connect4.field.State;
import it.unicam.cs.pa.connect4.players.BotPlayer;

/**
 * @author Paoloni
 *
 */
public class BotPlayerTest {

	@Test
	public void randomTest() {
		int[] a = new int[1000];
		for(int i = 0; i<1000; i++) {
			a[i] = (int) (Math.random() * 7);
			assertTrue(a[i]>=0 && a[i]<=6);
		}
	}
	
	@Test
	public void addCheckerTest() throws IOException {
		GameField g = new GameField();
		BotPlayer p = new BotPlayer(1, State.CROSS);
		g.placeChecker(p.place(), State.CROSS);
		assertEquals(g.getBoard()[g.getLastMove().getRow()][g.getLastMove().getColumn()].getCellState(), State.CROSS);
	}
	
	
}

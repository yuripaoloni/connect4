/**
 * 
 */
package it.unicam.cs.pa.connect4.test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.connect4.field.Move;
import it.unicam.cs.pa.connect4.field.State;
import it.unicam.cs.pa.connect4.players.BotPlayer;

/**
 * @author Paoloni
 *
 */
public class FieldCoordinatorTest {

	
	@Test
	public void testField() {
		BotPlayer p = new BotPlayer(1, State.CIRCLE);
		Move m = new Move(1, 1, State.CIRCLE);
		p.setOpponentMoveFieldStatus(m.getColumn(), m.getRow(), m.getState());
		
		assertEquals(p.getOpponentMoveFieldStatus(m.getRow(), m.getColumn()), State.CIRCLE);
	}
}

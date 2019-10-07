/**
 * 
 */
package it.unicam.cs.pa.connect4.test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.connect4.field.GameField;
import it.unicam.cs.pa.connect4.field.Move;
import it.unicam.cs.pa.connect4.field.State;

/**
 * @author Paoloni
 *
 */
public class FieldTest {
	
	@Test
	public void newBoardTest() {
		GameField b = new GameField();
		for( int i=0 ; i<b.getHeight() ; i++ ) {
			for( int j=0 ; j<b.getWidth() ; j++ ) {
				assertEquals(b.getBoard()[i][j].getCellState(), State.EMPTY);
			}
		}
	}
		
	@Test
	public void isColumnFullTest() {
		GameField b = new GameField();
		for( int i=0 ; i<b.getHeight() ; i++ ) {
			b.getBoard()[i][0].setCellState(State.CROSS);
		}
		assertTrue(b.isColumnFull(0));
	}
		
	@Test
	public void getRowPositionTest() {
		GameField b = new GameField();
		for( int i=0 ; i<b.getHeight() - 1 ; i++ ) {
			b.getBoard()[i][0].setCellState(State.CROSS);
		}
		assertEquals(b.getRowPosition(0), 5);
	}
	
	@Test
	public void verticalCheckTest() {
		GameField b = new GameField();
		for(int i = 0; i<4; i++) {
			b.setLastMove(new Move(b.getRowPosition(0), 0, State.CIRCLE));
			b.getBoard()[i][0].setCellState(State.CIRCLE);
		}
		assertEquals(b.isGameOver(b.getLastMove()), 1);
	}
	
	@Test
	public void horizontalCheckTest() {
		GameField b = new GameField();
		for(int i = 0; i<4; i++) {
			b.setLastMove(new Move(0, i, State.CIRCLE));
			b.getBoard()[0][i].setCellState(State.CIRCLE);
		}
		assertEquals(b.isGameOver(b.getLastMove()), 1);
	}
	
	@Test
	public void diagonalCheckTest() {
		GameField b = new GameField();
		for(int i = 0; i<4; i++) {
			b.setLastMove(new Move(i, i, State.CIRCLE));
			b.getBoard()[i][i].setCellState(State.CIRCLE);
		}
		assertEquals(b.isGameOver(b.getLastMove()), 1);
	}

}

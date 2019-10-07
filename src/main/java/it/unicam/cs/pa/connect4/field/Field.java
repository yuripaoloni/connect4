/**
 * 
 */
package it.unicam.cs.pa.connect4.field;

/**
 * Responsibility: This class provides the basic methods for a Connect4 game field.
 * 
 * @author Paoloni
 *
 */
public interface Field {
	
	/**
	 * Place a new checker in the column passed as argument and of the color passed as argument.
	 * @param column the column in which the new checker will be inserted
	 * @param color the color of the new checker.
	 */
	public void placeChecker(int column, State color);
	
	/**
	 * @param column the column to be checked
	 * @return <code>true</code> if the column is full, <code>false</code>
	 *         otherwise.
	 */
	public boolean isColumnFull(int column);
	
	/**
	 * @return <code>true</code> if the current board is full, <code>false</code>
	 *         otherwise.
	 */
	public boolean isBoardFull();
	
	/**
	 * Takes as parameter the row and the column of the last checker that has been
	 * played thanks to the <code>Move</code> object <code>lastMove</code>, and
	 * checks if there are four in a row of that same color vertically,
	 * horizontally or diagonally.
	 * 
	 * @param lastMove
	 * @return <code>1</code> if the winning condition is reached, <code>2</code> if
	 *         the board is full and it's a tie or <code>0</code> otherwise.
	 */
	public int isGameOver(Move lastMove);
	
	/**
	 * 
	 * @return the last move.
	 */
	public Move getLastMove();
	
	/**
	 * 
	 * @param lastMove
	 */
	public void setLastMove(Move move);
	
	/**
	 * 
	 * @return the current board
	 */
	public Cell[][] getBoard();
		
	/**
	 * 
	 * @return the width of the current grid
	 */
	public int getWidth();
	
	/**
	 * 
	 * @return the height of the current grid
	 */
	public int getHeight();

}

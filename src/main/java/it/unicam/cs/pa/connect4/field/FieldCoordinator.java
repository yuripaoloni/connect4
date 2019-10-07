/**
 * 
 */
package it.unicam.cs.pa.connect4.field;

/**
 * Responsibility : This abstract class is provided for all the players who wants to keep track of each move did in the current game.
 * 
 * @author Paoloni
 *
 */
public abstract class FieldCoordinator {

	/**
	 * the current game field.
	 */
	private Field field;
	
	/**
	 * the field containing all the moves did by this player.
	 */
	private Field myMove;
	
	/**
	 * the field containing all the moves did by the opponent.
	 */
	private Field opponentMove;
	
	public FieldCoordinator() {
		this.field = new GameField();
		this.myMove = new GameField();
		this.opponentMove = new GameField();
	}
	
	/**
	 * 
	 * @return the last move did by this player.
	 */
	public Move getMyLastMove() {
		return myMove.getLastMove();
	}
	
	/**
	 * 
	 * @return the last move did by the opponent.
	 */
	public Move getOpponentLastMove() {
		return opponentMove.getLastMove();
	}
	
	/**
	 * 
	 * @return the last move of the current game.
	 */
	public Move getFieldLastMove() {
		return field.getLastMove();
	}
	
	/**
	 * Returns the state of <code>myMove</code> field in the column and row passed as arguments.
	 * 
	 * @param row the row in which check.
	 * @param column the column in which check.
	 * @return the state of the cell identified by the row and column passed as argument.
	 */
	public State getMyMoveFieldStatus(int row, int column) {
		return myMove.getBoard()[row][column].getCellState();
	}
	
	/**
	 * Update the <code>myMove</code> field status adding the latest move.
	 * @param move the latest move did by this player.
	 */
	public void setMyMoveFieldStatus(Move move) {
		myMove.getBoard()[move.getRow()][move.getColumn()].setCellState(move.getState());
		myMove.setLastMove(move);
	}
	
	/**
	 * Returns the state of <code>opponentMove</code> field in the column and row passed as arguments.
	 * 
	 * @param row the row in which check.
	 * @param column the column in which check.
	 * @return the state of the cell identified by the row and column passed as argument.
	 */
	public State getOpponentMoveFieldStatus(int row, int column) {
		return opponentMove.getBoard()[row][column].getCellState();
	}
	
	/**
	 * Update the <code>opponentMove</code> field status adding the latest move.
	 * 
	 * @param column the column in which the opponent has placed.
	 * @param row the row in which the opponent has placed.
	 * @param color the color of the opponent.
	 */
	public void setOpponentMoveFieldStatus(int column, int row, State color) {
		opponentMove.getBoard()[row][column].setCellState(color);
		opponentMove.setLastMove(new Move(row, column, color));
	}
	
	/**
	 * Returns the state of the current game field in the column and row passed as arguments.
	 * 
	 * @param row the row in which check.
	 * @param column the column in which check.
	 * @return the state of the cell identified by the row and column passed as argument.
	 */
	public State getFieldStatus(int row, int column) {
		return field.getBoard()[row][column].getCellState();
	}
	
	/**
	 * Update the current game field status adding the latest move.
	 * @param column the last column in which a player has placed.
	 */
	public void setFieldStatus(int column, State color) {
		field.placeChecker(column, color);
	}

	/**
	 * 
	 * @return the current game field.
	 */
	public Field getField() {
		return field;
	}

	/**
	 * 
	 * @return the field containing all the moves did by this player. 
	 */
	public Field getMyMove() {
		return myMove;
	}

	/**
	 * 
	 * @return the field containing all the opponent move.
	 */
	public Field getOpponentMove() {
		return opponentMove;
	}
}

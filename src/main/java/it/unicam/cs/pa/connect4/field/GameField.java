/**
 * 
 */
package it.unicam.cs.pa.connect4.field;

import java.util.stream.IntStream;

/**
 * Responsibility : This class manage all the operations about the game field. 
 * Creates a board of 6x7, provides methods for doing checks on the board and applies the algorithm for checking the winning condition.
 * 
 * @author Paoloni
 */
public class GameField implements Field{

	private static final int WIDTH = 7;
	private static final int HEIGHT = 6;
	
	/**
	 * the board of 6x7.
	 */
	private Cell[][] board;
	
	/**
	 * the last move did on the current board.
	 */
	private Move lastMove;

	/**
	 * Initialize the game board to be a 6 by 7 array of <code>Cell</code> objects
	 * all set to <code>State.EMPTY</code>. 
	 */
	public GameField() {
		lastMove = new Move();
		this.board = new Cell[HEIGHT][WIDTH];
		IntStream.range(0, HEIGHT)
				.forEach(row -> IntStream.range(0, WIDTH).forEach(column -> board[row][column] = new Cell(State.EMPTY)));
	}
	
	@Override
	public void placeChecker(int column, State color) {
		this.setLastMove(new Move(this.getRowPosition(column), column, color));
		this.getBoard()[this.getRowPosition(column)][column].setCellState(color);
	}

	@Override
	public boolean isColumnFull(int column) {
		return this.board[0][column].getCellState() == State.EMPTY ? false : true;
	}

	@Override
	public boolean isBoardFull() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (this.board[i][j].getCellState() == State.EMPTY)
					return false;
			}
		}
		return true;
	}

	/**
	 * It returns the position of the last empty row in a column.
	 * 
	 * @param column
	 * @return the last empty row where the checker will be inserted
	 */
	public int getRowPosition(int column) {
		int rowPosition = -1;
		for (int i = 0; i < HEIGHT; i++) {
			if (this.board[i][column].getCellState() == State.EMPTY) {
				rowPosition = i;
			}
		}
		return rowPosition;
	}

	@Override
	public int isGameOver(Move lastMove) {

		if (verticalCheck(lastMove))
			return 1;

		if (horizontalCheck(lastMove))
			return 1;

		if (diagonalCheck())
			return 1;

		if (this.isBoardFull())
			return 2;

		return 0;
	}

	/**
	 * Check if there are 4 checker in a row horizontally.
	 * 
	 * @param lastMove
	 * @return <code>true</code> if there are 4 in a row, <code>false</code>
	 *         otherwise.
	 */
	private boolean horizontalCheck(Move lastMove) {
		int counter = 0;
		for (int i = 6; i >= 0; i--) {
			counter = this.board[lastMove.getRow()][i].getCellState() == lastMove.getState() ? ++counter : 0;
			if (counter >= 4)
				return true;
		}
		return false;
	}

	/**
	 * Check if there are 4 checker in a row vertically.
	 * 
	 * @param lastMove
	 * @return <code>true</code> if there are 4 in a row, <code>false</code>
	 *         otherwise.
	 */
	private boolean verticalCheck(Move lastMove) {
		int counter = 0;
		for (int i = 5; i >= 0; i--) {
			counter = this.board[i][lastMove.getColumn()].getCellState() == lastMove.getState() ? ++counter : 0;
			if (counter >= 4)
				return true;
		}
		return false;
	}

	/**
	 * Check if there are 4 checker in a row diagonally, both ascending and
	 * descending.
	 * 
	 * @return <code>true</code> if there are 4 in a row, <code>false</code>
	 *         otherwise.
	 */
	private boolean diagonalCheck() {
		for (int row = 0; row < HEIGHT - 3; row++) {
			for (int column = 0; column < WIDTH - 3; column++) {
				if (this.board[row][column].getCellState() != State.EMPTY
						&& this.board[row][column].getCellState() == this.board[row + 1][column + 1].getCellState()
						&& this.board[row][column].getCellState() == this.board[row + 2][column + 2].getCellState()
						&& this.board[row][column].getCellState() == this.board[row + 3][column + 3].getCellState())
					return true;
			}
			for (int col = 3; col < WIDTH; col++) {
				if (board[row][col].getCellState() != State.EMPTY
						&& board[row][col].getCellState() == board[row + 1][col - 1].getCellState()
						&& board[row][col].getCellState() == board[row + 2][col - 2].getCellState()
						&& board[row][col].getCellState() == board[row + 3][col - 3].getCellState())
					return true;
			}
		}
		return false;
	}

	public Move getLastMove() {
		return lastMove;
	}


	public void setLastMove(Move move) {
		this.lastMove = move;
	}

	public Cell[][] getBoard() {
		return board;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}	
}

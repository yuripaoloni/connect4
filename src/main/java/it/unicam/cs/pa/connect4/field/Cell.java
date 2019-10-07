/**
 * 
 */
package it.unicam.cs.pa.connect4.field;

/**
 * Responsibility : This class stores the information about the cell. Using this class we can have an object in every cells and 
 * run methods on it for checking the state of the cell.
 * 
 * @author Paoloni
 */

public class Cell{
	
	/**
	 * the state of this cell
	 */
	private State cellState;
	
	public Cell(State cellState) {
		this.cellState = cellState;
	}
	
	/**
	 * 
	 * @return the symbol of this cell
	 */
	public State getCellState() {
		return cellState;
	}
	
	/**
	 * 
	 * @param cellState the symbol to be added in this cell
	 */
	public void setCellState(State cellState) {
		this.cellState = cellState;
	}
	
}

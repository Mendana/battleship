package team2.mp.battleship.model.board;


public class Coordinate {
	
	// Constant values
	/** List of letters */
	public static final char[] LETTERS_FOR_COLS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};
	
	// Enumerate for the directions
	public enum Direction {
		NORTH, EAST, SOUTH, WEST;
	}
	
	// Attributes
	private int col;
	private int row;
			
	/**
	 * Constructor with the params x and y for the cols and rows
	 * 
	 * @param col, position in the x axis
	 * @param row, position in the y axis
	 * @throws IllegalArgumentException if the row or the column are lower than 0
	 */
	public Coordinate(int col, int row) {
		this.col = col;
		this.row = row;
	}

	/**
	 * Returns the value of the column (x value)
	 * 
	 * @return int with the column value
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Returns the value of the row (y value)
	 * 
	 * @return int with the row value
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Returns a string with the information of the coordinate with the following format:
	 * Coordenada [ x = 0, y = 0 ]
	 * 
	 * @returns String with the information of the coordinate in the previous format
	 */
	@Override
	public String toString() {
		return String.format("Coordenada [ x = %d, y = %d ]", getCol(), getRow());
	}

	/**
	 * Returns a string with the information of the coordinate but with an easier format for the user
	 * For example, the coordinate [ x = 2 ,y = 0 ] would be: C-1
	 * 
	 * @return String with the information of the coordinate and the previous format
	 */
	public String toUserString() {
		return String.format("%s-%d", colPosToChar(getCol()), getRow() + 1);
	}
	
	/**
	 * Checks if a given object is a coordinate and has the same values as the coordinate
	 * 
	 * @param o, object to compare with the coordinate
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return col == other.col && row == other.row;
	}
	
	/**
	 * Changes the coordinate to the given direction and returns the coordinate
	 * 
	 * @param direction, Direction to move the coordinate
	 * @return new Coordinate with the new position
	 */
	public Coordinate go(Direction direction) {
		switch (direction) {
		case NORTH:
			return new Coordinate(getCol(), getRow() - 1);
		case SOUTH:
			return new Coordinate(getCol(), getRow() + 1);			
		case EAST:
			return new Coordinate(getCol() + 1, getRow());
		case WEST:
			return new Coordinate(getCol() - 1, getRow());		
		default:
			return null;
		}
	}

	/**
	 * Changes the column number to the correspondent letter
	 * 
	 * @param col, int with the value of the column
	 * @return char with the letter that represents that column
	 */
	private char colPosToChar(int col) {
		return LETTERS_FOR_COLS[col];
	}
}

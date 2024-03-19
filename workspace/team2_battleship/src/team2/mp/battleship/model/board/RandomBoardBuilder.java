package team2.mp.battleship.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import team2.mp.battleship.model.board.Coordinate.Direction;
import team2.mp.battleship.model.board.squares.Ship;
import team2.mp.battleship.model.board.squares.Water;

class RandomBoardBuilder {
	
	private static int BOARD_SIZE = 0;

	/**
	 * Builds the board with the given size and fleet
	 *  
	 * @param size, int with the dimension of the board
	 * @param fleet, list of ships that are going to be in the board
	 * @return square[][] matrix of squares with their respective content
	 */
	static Square[][] build(int size, List<Ship> fleet) {
		Square[][] board = new Square[size][size];
		BOARD_SIZE = size;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Square();
				board[i][j].setContent(new Water());
			}
		}
		
		List<Ship> copyFleet = copyShips(fleet);
		List<Ship> shortedFleet = shortList(copyFleet);
		
		Random random = new Random();
		for (Ship ship : shortedFleet) {
			boolean condition = false;
			do {
				Coordinate coord = new Coordinate(random.nextInt(size), random.nextInt(size));
				condition = setShip(ship, coord, board);
			} while (!condition);
		}
		return board;
	}
	
	/**
	 * Creates a copy of the ships
	 * 
	 * @param ships, list of ship in order to be set in the board
	 * @return List<Ship> copy of the fleet list
	 */
	private static List<Ship> copyShips(List<Ship> ships){
		List<Ship> fleet = new ArrayList<Ship>();
		for (Ship ship : ships) {
			fleet.add(ship);
		}
		return fleet;
	}

	/**
	 * Shorts the list in order to have the biggest ships first
	 * 
	 * @param list, List to short
	 * @return List of ships with the same content as the parameter but shorted
	 */
	private static List<Ship> shortList(List<Ship> list) {
		List<Ship> shortedShips = new ArrayList<>(list);
		int[] i = getLimitSize(list);
		int maxSize = i[1];
		int minSize = i[0];
		
		while(maxSize > minSize) {
			for (Ship ship : list) {
				if(ship.size() == maxSize) {
					shortedShips.add(ship);
				}
			}
			maxSize--;
		}
		return shortedShips;
	}
		
	/**
	 * Returns an array with two values, {minSize, maxSize}
	 * minSize --> the smallest size of a ship in the list
	 * maxSize --> the biggest size of a ship in the list
	 * 
	 * @param ships, list of ships to analyze
	 * @return array of two elements with the smallest and biggest size of the ships in the list
	 */
	private static int[] getLimitSize(List<Ship> ships) {
		int[] sizes = {Ship.MAX_SHIP_SIZE, Ship.MIN_SHIP_SIZE};
		for (Ship ship : ships) {
			int shipSize = ship.size();
			if(shipSize > sizes[0]) {
				sizes[0] = shipSize;
			}
			if(shipSize < sizes[1]) {
				sizes[1] = shipSize;
			}
		}
		return sizes;
	}
	
	/**
	 * Tries to set a ship in a given coordinate of the board (in case of been a ship with more than one square,
	 * the coordinate will be the first square of the ship)
	 * 
	 * @param ship, Ship to set in the board
	 * @param coord, Coordinate where to try to set the ship
	 * @param board, board where is going to be set the ship
	 * @return boolean with true if it can set the ship in the board with the given coordinate
	 */
	private static boolean setShip(Ship ship, Coordinate coord, Square[][] board) {
		if(!(board[coord.getRow()][coord.getCol()].getContent() instanceof Water)) {
			return false;
		} 
		if(ship.size() == 1) {
			if(isNotSurrounded(coord, board)) {
				board[coord.getRow()][coord.getCol()].setContent(ship);
				return true;	
			} else {
				return false;
			}
		}
		
		Direction direction = getDirection(ship, coord, board);
		if(direction != null) {
			locateShip(coord, ship, direction, board);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Generates a random direction and checks if it is a valid direction (starting from the coordinate and moving
	 * in the direction as many times as squares has the boat. It wont be a valid direction if:
	 * 1. Any coordinate is out of bound
	 * 2. Any coordinate already has content
	 * 3. Any coordinate has a boat in the surrounding squares.
	 * In case of having any invalid coordinate it will return null. If not, it will return the direction
	 * 
	 * @param ship, the Ship that has to be located
	 * @param coord, Coordinate where the ship is going to be located (if it has more than one square, this will be
	 * 			the position of the first square of the ship)
	 * @param board, board where the ship is going to be set
	 * @return Direction if it is valid or null if not
	 */
	private static Direction getDirection(Ship ship, Coordinate coord, Square[][] board) {
		Direction direction = randomDirection();
		for(int i = 0; i < ship.size(); i++) {
			if(!isInBoard(coord) || !isFreePositon(coord, board) || !isNotSurrounded(coord, board)) {
				return null;
			}
			coord = coord.go(direction);
		}
		return direction;
	}

	/**
	 * Generates a random direction
	 * 
	 * @return random direction (NORTH, SOUTH, EAST or WEST)
	 */
	private static Direction randomDirection() {
		Random random = new Random();
		int i = random.nextInt(4);
		switch (i) {
		case 0: 
			return Direction.NORTH;
		case 1:
			return Direction.EAST;
		case 2:
			return Direction.SOUTH;
		default:
			return Direction.WEST;
		}
	}
	
	/**
	 * Checks if a position is in the board (in the dimension of the board)
	 * 
	 * @param coord, coordinate to check
	 * @return boolean with true if the coordinate is in the board
	 */
	private static boolean isInBoard(Coordinate coord) {
		if(coord.getCol() < 0 || coord.getCol() >= BOARD_SIZE
				|| coord.getRow() < 0 || coord.getRow() >= BOARD_SIZE) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the content of a square is not a ship
	 * 
	 * @param coord, Coordinate to check
	 * @param board, Board where to check the coordinate
	 * @return boolean with true if the coordinate is free (not with a ship)
	 */
	private static boolean isFreePositon(Coordinate coord, Square[][] board) {
		return !(board[coord.getRow()][coord.getCol()].getContent() instanceof Ship);
	}
	
	/**
	 * Checks if there are any not free squares in the surrounding of the coordinate
	 * 
	 * @param coord, Coord to check
	 * @param board, board where to check
	 * @return boolean with true if there are only free square surrounding square
	 */
	private static boolean isNotSurrounded(Coordinate coord, Square[][] board) {
		if(isInBoard(coord.go(Direction.NORTH)) && !isFreePositon(coord.go(Direction.NORTH), board)){
			return false;
		}
		if(isInBoard(coord.go(Direction.SOUTH)) && !isFreePositon(coord.go(Direction.SOUTH), board)){
			return false;
		}
		if(isInBoard(coord.go(Direction.EAST)) && !isFreePositon(coord.go(Direction.EAST), board)){
			return false;
		}
		if(isInBoard(coord.go(Direction.WEST)) && !isFreePositon(coord.go(Direction.WEST), board)){
			return false;
		}
		return true;
		
	}
	
	/**
	 * Locates the ship in the board. It follows the a given direction starting at the given coordinate
	 * 
	 * @param coord, Coordinate where the ship is going to be located (or where it is going to have the first square)
	 * @param ship, Ship that is going to be located
	 * @param direction, Direction in which the board is going to be located
	 * @param board, Board where the ship is going to be located
	 */
	private static void locateShip(Coordinate coord, Ship ship, Direction direction, Square[][] board) {
		for(int i = 0; i < ship.size(); i++) {
			board[coord.getRow()][coord.getCol()].setContent(ship);
			coord = coord.go(direction);
		}
	}
}
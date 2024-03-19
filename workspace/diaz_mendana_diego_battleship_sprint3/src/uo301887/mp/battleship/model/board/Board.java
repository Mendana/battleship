package uo301887.mp.battleship.model.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;
import uo301887.mp.battleship.model.board.Square.Damage;
import uo301887.mp.battleship.model.board.squares.Ship;

public class Board {
	
	// Constant values
	/** Part of a battleship */
	public static final char BATTLESHIP_PART = 'B';
	
	/** Part of a cruiser */
	public static final char CRUISER_PART = 'C';
	
	/** Part of a destroyer */
	public static final char DESTROYER_PART = 'D';
	
	/** Part of a submarine */
	public static final char SUBMARINE_PART = 'S';
	
	/** Hit position */
	public static final char HIT_POSITION = '*';
	
	/** Missed shot */
	public static final char MISSED_SHOT = '\u00F8';
	
	/** Blank space */
	public static final char BLANK_SPACE = ' ';
	
	/** Default list of ships */
	public static final List<Ship> FLEET = createFleet();
	
	/**Creates a default fleet */
	public static final List<Ship> createFleet() {
		List<Ship> fleet = new ArrayList<>();
		for (int i = 4; i > 0; i--) {
			for (int j = i; j <= 4; j++) {
				fleet.add(new Ship(i));
			}
		}
		return fleet;
	}
	
	
	// Attributes
	private Square[][] grid;

	/**
	 * Constructor with the size of the board
	 * 
	 * @param size, int with size of the board
	 * @param random, boolean with true if the board is going to be random
	 */
	public Board(int size, boolean random){
		grid = (random)? RandomBoardBuilder.build(size, FLEET):BoardBuilder.build(size, FLEET);
	}
	
	/**
	 * Constructor with the parameter board. Creates the board with a given matrix
	 * 
	 * @param arg, matrix or board to create.
	 * @throws IllegalArgumentException if the parameter is null
	 */
	protected Board(Square[][] arg) {
		ArgumentChecks.isNotNull(arg);
		grid = arg;
	}

	/**
	 * This method checks if there is a ship in a coordinate. If there is one, it will return true and mark as hit
	 * the position of the ship. If there was already a hit it will return also true.
	 * In case there is no ship in the position it will return false and mark the position as failed
	 * 
	 * @param position, Coordinate with the x and y values of the position to shoot at
	 * @return Damage with the damage of the shot (NO_DAMAGE, MASSIVE_DAMAGE or SEVERE_DAMAGE)
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public Damage shootAt(Coordinate position) {
		ArgumentChecks.isNotNull(position);
		return grid[position.getRow()][position.getCol()].shootAt();
	}
	
	/**
	 * This method checks if every ship is sunk
	 * 
	 * @return boolean with true if all ships are sunk or false if not
	 */
	public boolean isFleetSunk() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(isShip(grid[i][j].toChar())) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method returns the dimension of the board
	 * 
	 * @return int with the dimension of the board
	 */
	public int getSize() {
		return grid.length;
	}

	/**
	 * This method returns a matrix with the satus of the board. It will have a B if there is a part of a battleship,
	 * a C if there is a part of a crusier, a D if there is a part of a destroyer, an s if there is a submarine, a *
	 * if there is a hit, a Ø if there is missed shot or a blank space " " if the position is unknown
	 * 
	 * @return a matrix with the full status of the board with the previous chars
	 */
	public char[][] getFullStatus() {
		char[][] charMatrix = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				charMatrix[i][j] = gridToChar(i, j);
			}
		}
		return charMatrix;
	}

	/**
	 * This method returns a matrix similar to the fullStatus but only shows the squares that have been hit. The ones
	 * that have not been shot will be with a blank character (even if they have a part of a ship)
	 * 
	 * @return a matrix of the board with the previous information
	 */
	public char[][] getMinimalStatus() {
		char[][] charMatrix = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				charMatrix[i][j] = gridToMinimalChar(i, j);
			}
		}
		return charMatrix;
	}
	
	/**
	 * This method returns a copy of the grid
	 * 
	 * @return Square[][] with a copy of the board (grid)
	 */
	Square[][] getInnerArray(){
		Square[][] copiedMatrix = new Square[grid.length][grid[0].length];
		for (int i = 0; i < copiedMatrix.length; i++) {
			copiedMatrix[i] = grid[i].clone();
		}
		return copiedMatrix;
	}

	/**
	 * Receives a position in the grid and checks the value in order to return a char with the following values:
	 * 'B' --> part of a battleship
	 * 'C' --> part of a cruiser
	 * 'D' --> part of a destroyer
	 * 'S' --> a submarine
	 * '*' --> hit square of the grid (there was a part of a ship
	 * 'Ø' --> missed shot
	 * ' ' --> Water
	 * 
	 * @param row, row to check
	 * @param column, column to check
	 * @return a char with the correspondent value
	 */
	private char gridToChar(int row, int column) {
		return grid[row][column].toChar();
	}
	
	/**
	 * Receives a position in the grid and checks the value in order to return a char with the following values:
	 * '*' --> hit square of the grid (there was a part of a ship
	 * 'Ø' --> missed shot
	 * '#' --> Sink ship
	 * ' ' --> Unknown
	 * 
	 * @param row, row to check
	 * @param col, column to check
	 * @return a char with the correspondent value
	 */
	private char gridToMinimalChar(int row, int col) {
		return (grid[row][col].toChar() == MISSED_SHOT
				|| grid[row][col].toChar() == HIT_POSITION
				|| grid[row][col].toChar() == Ship.SUNK_SHIP)? grid[row][col].toChar():BLANK_SPACE;
	}
	
	/**
	 * Checks if there is any ship alive in the given square. If there is, it will return true
	 * 
	 * @param content, char with the information of the square
	 * @return boolean with true if there is a ship part in the square.
	 */
	private boolean isShip(char content) {
		switch (content) {
		case BATTLESHIP_PART: case CRUISER_PART: case DESTROYER_PART: case SUBMARINE_PART:
			return true;	
		default:
			return false;
		}
	}
}

package uo301887.mp.battleship.model.player;

import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;
import uo301887.mp.battleship.interaction.GameInteractor;
import uo301887.mp.battleship.model.board.Board;
import uo301887.mp.battleship.model.board.Coordinate;
import uo301887.mp.battleship.model.board.Square.Damage;

public class Player {

	// Attributes
	private String name;
	private Board myShips;
	private Board myOpponentShips;
	private GameInteractor gameInteractor;
	private List<Coordinate> shotCoordinates = new ArrayList<>();

	/**
	 * Constructor with the name parameter
	 * 
	 * @param name, String with the name of the player
	 * @throws IllegalArgumentException if the name is blank or null
	 */
	public Player(String name) {
		ArgumentChecks.isNotNull(name);
		ArgumentChecks.isNotBlank(name);
		setName(name);
	}
	/**
	 * This method returns the player´s name
	 * 
	 * @return String with the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns the value board (parameter) to the game board of the player
	 * 
	 * @param board, matrix of integers to set the player´s game board
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setMyShips(Board board) {
		ArgumentChecks.isNotNull(board);
		this.myShips = board;
	}

	/**
	 * Assigns the value board (parameter) to the game board of the opponent player
	 * 
	 * @param board, matrix of integers to set the opponents´s game board
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setOpponentShips(Board board) {
		ArgumentChecks.isNotNull(board);
		this.myOpponentShips = board;
	}

	/**
	 * Shoots at a given position of opponent´s board. If it hits any ship the method returns
	 * SEVERE_DAMAGE if it is not sunk or MASSIVE_DAMAGE if it is sunk. If it does not hit
	 * any ship it returns MISSED_SHOT
	 * 
	 * @param position, Coordinate where player is going to shoot at
	 * @return Damage of the shot with the previous information
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public Damage shootAt(Coordinate position) {
		ArgumentChecks.isNotNull(position);
		return getOpponentShips().shootAt(position);
	}

	/**
	 * Returns the player´s board
	 * 
	 * @return Board, player´s board
	 */
	public Board getMyShips() {
		return myShips;
	}

	/**
	 * Returns the opponent´s board
	 * 
	 * @return Board, opponent´s Board
	 */
	public Board getOpponentShips() {
		return myOpponentShips;
	}

	/**
	 * Returns true if enemy´s fleet is sunk
	 * 
	 * @return boolean with true if enemy´s fleet is sunk or false if not
	 */
	public boolean hasWon() {
		return getOpponentShips().isFleetSunk();
	}

	/**
	 * Reads the coordinates written in the console and returns a coordinate object with the values
	 * 
	 * @return Coordinate with the values written by the user in the screen
	 */
	public Coordinate makeChoice() {
		do {
			Coordinate coordinateToShot = getGameInteractor().getTarget();
			if(!shotCoordinates.contains(coordinateToShot)) {
				shotCoordinates.add(coordinateToShot);
				return coordinateToShot;
			}
		} while (true);
	}
	
	/**
	 * Adds the gameInteractor for the game
	 * 
	 * @param arg, GameInteractor for the game
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setInteractor(GameInteractor arg) {
		ArgumentChecks.isNotNull(arg);
		this.gameInteractor = arg;
	}
	
	/**
	 * Sets the value of the name of the player
	 * 
	 * @param name, String with the name of the player
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the value of the gameInteractor
	 * 
	 * @return GameInteractor of the player
	 */
	GameInteractor getGameInteractor() {
		return this.gameInteractor;
	}

}
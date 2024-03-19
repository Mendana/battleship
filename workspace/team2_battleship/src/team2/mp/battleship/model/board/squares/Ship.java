package team2.mp.battleship.model.board.squares;

import team2.mp.battleship.model.board.Square.Damage;
import uo.mp.util.check.ArgumentChecks;

public class Ship implements Target{
	
	//Constant values
	/** Minimum size of the ship */
	public static final int MIN_SHIP_SIZE = 1;

	/** Max size of the ship */
	public static final int MAX_SHIP_SIZE = 4;
	
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
	
	/** Sunk ship */
	public static final char SUNK_SHIP = '#';
	
	// Attributes
	private int size;
	private int shotCount;
	
	/**
	 * Constructor with the parameter shipSize.
	 * 
	 * @param shipSize, integer with the size of the ship
	 * @throws IllegalArgumentException if the size is below 1 or above 4
	 */
	public Ship(int shipSize) {
		setSize(shipSize);
		setShotCount(0);
	}
	
	/**
	 * Returns the damage due to a shot to the ship. If the ship sinks with the shot, the damage will be Massive.
	 * If not, it will be severe.
	 * 
	 * @return Damage value, with SEVERE if the ship does not sink or MASSIVE in the ship has no squares left
	 */
	@Override
	public Damage shootAt() {
		setShotCount(getShotCount() + 1);
		return (isSunk())? Damage.MASSIVE_DAMAGE : Damage.SEVERE_DAMAGE;
	}
	

	/**
	 * Gets the value of the size of the ship
	 * 
	 * @return integer with the size of the ship
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Checks if the ship is sunk (all the squares have been hit
	 * 
	 * @return boolean with true if the ships is sunk or false if not
	 */
	public boolean isSunk() {
		return (getShotCount() < size())? false:true;
	}
	
	/**
	 * Returns the type of ship with the following description
	 * S --> Submarine
	 * D --> Destroyer
	 * C --> Cruiser
	 * B --> Battleship
	 * 
	 * @return the char according to the previous information
	 */
	@Override
	public char toChar() {
		switch (size()) {
		case 1:
			return SUBMARINE_PART;
		case 2:
			return DESTROYER_PART;
		case 3:
			return CRUISER_PART;
		default:
			return BATTLESHIP_PART;
		}
	}
	
	/**
	 * Returns the status of ship with the following description
	 * * --> hit
	 * # --> Sunk
	 * 
	 * @return the char according to the previous information
	 */
	@Override
	public char toFiredChar() {
		return isSunk()? SUNK_SHIP : HIT_POSITION;
	}

	
	/**
	 * Sets the value of the size of the ship
	 * 
	 * @param size, integer with the size of the ship
	 * @throws IllegalArgumentException if the size is below 1 or if it is bigger than 4
	 */
	private void setSize(int size) {
		ArgumentChecks.isTrue(size >= MIN_SHIP_SIZE && size <= MAX_SHIP_SIZE, " is an invalid argument");
		this.size = size;
	}

	/**
	 * Gets the value of the of the shots in the ship
	 * 
	 * @return integer with the number of shots to the ship
	 */
	protected int getShotCount() {
		return shotCount;
	}

	/**
	 * Sets the value of the shots to the ship
	 * 
	 * @param shotCount, integer with the number of shots of the ship
	 * @throws IllegalArgumentException if the shotCount is negative
	 */
	private void setShotCount(int shotCount) {
		ArgumentChecks.isTrue(shotCount >= 0, " is an invalid argument");
		this.shotCount = shotCount;
	}
	
	
	
}
 
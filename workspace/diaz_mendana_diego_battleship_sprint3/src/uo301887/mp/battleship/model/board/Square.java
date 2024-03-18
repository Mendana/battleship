package uo301887.mp.battleship.model.board;

import uo301887.mp.battleship.model.board.squares.Target;

public class Square {

	
	// Attributes
	private Target content;
	private boolean shot;
	
	public enum Damage {
		NO_DAMAGE, SEVERE_DAMAGE, MASSIVE_DAMAGE;
	}
	
	/**
	 * Default Constructor
	 * Sets the content to null
	 * Sets the shots false
	 */
	public Square() {
		setContent(null);
		setShot(false);
	}

	/**
	 * Shoots at the square and returns a value depending on the effectiveness of the shot:
	 * NO_DAMAGE --> No ships hit
	 * SEVERE_DAMAGE --> Ship hit but not sunk
	 * MASSIVE_DAMAGE --> Ship sunk
	 * 
	 * @return Damage, enum value with the result of the shot
	 */
	Damage shootAt() {
		setShot(true);
		return content.shootAt();
	}
	
	/**
	 * Checks if the square has been shot
	 * 
	 * @return boolean with true if it has been shot. False if not.
	 */
	boolean isShot() {
		return shot;
	}
	
	/**
	 * Returns a char with the value of the square:
	 * B --> Battleship
	 * C --> Cruiser
	 * D --> Destroyer
	 * S --> Submarine
	 * * --> Hit
	 * # --> Sunk
	 * ϕ --> Missed shot
	 *   --> Water
	 *   
	 * @return a char with the previous information
	 */
	char toChar() {
		return shot? content.toFiredChar():content.toChar();
	}
	
	/**
	 * Sets the value of the content to a given one
	 * 
	 * @param content, target of the square
	 */
	Square setContent(Target content) {
		this.content = content;
		return this;
	}
	
	/**
	 * Checks if the square has content (Ship or Water)
	 * 
	 * @return boolean with true if it has content
	 */
	boolean hasContent() {
		return (content != null)? true:false;
	}
	
	/**
	 * Returns the value of the content
	 * 
	 * @return Target with the content of the square (ship or water)
	 */
	Target getContent() {
		return content;
	}

	/**
	 * Gets if the square has been shot
	 * 
	 * @return boolean with true if it has been shot
	 */
	boolean getShot() {
		return shot;
	}

	/**
	 * Sets the value of shot
	 * 
	 * @param shot, boolean with true if it has been shot
	 */
	private void setShot(boolean shot) {
		this.shot = shot;
	}
	
	
}

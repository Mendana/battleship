package uo301887.mp.battleship.model.board.squares;

import uo301887.mp.battleship.model.board.Square.Damage;

public class Water implements Target{

	// Constant values
	/** Missed shot */
	public static final char MISSED_SHOT = '\u00F8';
	
	/** Blank space */
	public static final char BLANK_SPACE = ' ';
	
	/**
	 * Returns the Damage value of NO_DAMAGE
	 * 
	 * @return Damage, with NO_DAMAGE
	 */
	@Override
	public Damage shootAt() {
		return Damage.NO_DAMAGE;
	}
	
	/**
	 * Returns the blank char (the one that is associated to the water spaces)
	 * 
	 * @return char with the previous value
	 */
	@Override
	public char toChar() {
		return BLANK_SPACE;
	}
	
	/**
	 * Returns the char Ø (the one that is associated to the missed shots)
	 * 
	 * @return char with the previous value
	 */
	@Override
	public char toFiredChar() {
		return MISSED_SHOT;
	}
}

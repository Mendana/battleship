package uo301887.mp.battleship.interaction;

import java.util.Random;

import uo.mp.util.check.ArgumentChecks;
import uo301887.mp.battleship.model.board.Coordinate;

public class RandomGameInteractor implements GameInteractor{

	// Attributes
	private int size;
	
	/**
	 * Constructor with the parameter size
	 * 
	 * @param size, int with the size of the board
	 * @throw {@link IllegalArgumentException} if the size is 0 or negative
	 */
	public RandomGameInteractor(int size) {
		ArgumentChecks.isTrue(size > 0, "Must be higher than 0");
		this.size = size;
	}
	
	/**
	 * Generates a random coordinate
	 */
	@Override
	public Coordinate getTarget() {
		Random random = new Random();
		return new Coordinate(random.nextInt(size), random.nextInt(size));
	}

}

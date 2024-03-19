package team2.mp.battleship.interaction;

import team2.mp.battleship.model.board.Coordinate;

public interface GameInteractor {

	/**
	 * Generates a coordinate to shoot at and returns it
	 * 
	 * @return Coordinate to shootAt
	 */
	Coordinate getTarget();
}

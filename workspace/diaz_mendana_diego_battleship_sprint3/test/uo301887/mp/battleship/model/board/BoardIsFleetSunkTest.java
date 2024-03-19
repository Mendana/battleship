package uo301887.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardIsFleetSunkTest {
	
	// Attributes
	private Board board;

	@BeforeEach
	void setUp() throws Exception {
		board = new Board(10, false);
	}

	/**
	 * Use cases:
	 * 1. All the fleet is sunk
	 * 2. All the ships except one are sunk
	 * 3. Several ships are not sunk
	 */
	
	/**
	 * GIVEN a board with all ships hit
	 * WHEN looks if the fleet is sunk
	 * THEN returns true
	 */
	@Test
	public void isFleetSunkWithAllHit() {
		for (int i = 0; i < board.getInnerArray().length; i++) {
			for (int j = 0; j < board.getInnerArray()[i].length; j++) {
				Coordinate coordinate = new Coordinate(j, i);
				board.shootAt(coordinate);
			}
		}
		assertTrue(board.isFleetSunk());
	}
	
	/**
	 * GIVEN a board with all ships hit except one
	 * WHEN looks if the fleet is sunk
	 * THEN returns false
	 */
	@Test
	public void isFleetSunkWithOnlyOneLeft() {
		for (int i = 0; i < board.getInnerArray().length; i++) {
			for (int j = 0; j < board.getInnerArray()[i].length; j++) {
				if(i != 2 && j != 0) {
					Coordinate coordinate = new Coordinate(j, i);
					board.shootAt(coordinate);
				}
			}
		}
		assertFalse(board.isFleetSunk());
	}
	
	/**
	 * GIVEN a board with several ships up
	 * WHEN looks if the fleet is sunk
	 * THEN returns false
	 */
	@Test
	public void isFleetSunkWithSeveralLeft() {
		for (int i = 0; i < board.getInnerArray().length; i++) {
			for (int j = 0; j < board.getInnerArray()[i].length; j++) {
				if(i != 2) {
					Coordinate coordinate = new Coordinate(j, i);
					board.shootAt(coordinate);
				}
			}
		}
		assertFalse(board.isFleetSunk());
	}
}

package uo301887.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo301887.mp.battleship.model.board.Coordinate.Direction;

class BoardCoordinateGoTest {

	// Attributes
	private Coordinate coord;
	
	@BeforeEach
	void setUp() throws Exception {
		coord = new Coordinate(2,2);
	}
	
	/**
	 * Use cases:
	 * 1. A column to west
	 * 2. 0 row to north
	 * 3. Normal coordinate to north
	 * 4. Normal coordinate to south
	 * 5. Normal coordinate to west
	 * 6. Normal coordinate to east
	 */
	
	/**
	 * GIVEN a coordinate in the A column
	 * WHEN goes to the west
	 * THEN changes to row=0 and col=-1
	 */
	@Test
	void goAColToWest() {
		Coordinate coordinate = new Coordinate(0,1);
		Coordinate newCoordinate = coordinate.go(Direction.WEST);
		assertEquals(-1, newCoordinate.getCol());
		assertEquals(1, newCoordinate.getRow());
	}
	
	/**
	 * GIVEN a coordinate in the 0 row
	 * WHEN goes to the north
	 * THEN changes to row=-1 and col=0
	 */
	@Test
	void go0RowToNorth() {
		Coordinate coordinate = new Coordinate(1,0);
		Coordinate newCoordinate = coordinate.go(Direction.NORTH);
		assertEquals(1, newCoordinate.getCol());
		assertEquals(-1, newCoordinate.getRow());
	}
	
	/**
	 * GIVEN a coordinate (2,2)
	 * WHEN goes to the north
	 * THEN changes to row=1 and col=2
	 */
	@Test
	void goNorth() {
		Coordinate newCoordinate = coord.go(Direction.NORTH);
		assertEquals(2, newCoordinate.getCol());
		assertEquals(1, newCoordinate.getRow());
	}
	
	/**
	 * GIVEN a coordinate (2,2)
	 * WHEN goes to the south
	 * THEN changes to row=3 and col=2
	 */
	@Test
	void goSouth() {
		Coordinate newCoordinate = coord.go(Direction.SOUTH);
		assertEquals(2, newCoordinate.getCol());
		assertEquals(3, newCoordinate.getRow());
	}
	
	/**
	 * GIVEN a coordinate (2,2)
	 * WHEN goes to the west
	 * THEN changes to row=2 and col=1
	 */
	@Test
	void goWest() {
		Coordinate newCoordinate = coord.go(Direction.WEST);
		assertEquals(1, newCoordinate.getCol());
		assertEquals(2, newCoordinate.getRow());
	}
	
	/**
	 * GIVEN a coordinate (2,2)
	 * WHEN goes to the east
	 * THEN changes to row=2 and col=3
	 */
	@Test
	void goEast() {
		Coordinate newCoordinate = coord.go(Direction.EAST);
		assertEquals(3, newCoordinate.getCol());
		assertEquals(2, newCoordinate.getRow());
	}

}

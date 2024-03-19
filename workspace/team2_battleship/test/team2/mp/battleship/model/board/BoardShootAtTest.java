package team2.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.mp.battleship.model.board.Square.Damage;

class BoardShootAtTest {

	// Atributes
	private Coordinate coordWithShipSink;
	private Coordinate coordWithShipNotSink;
	private Coordinate coordEmpty;
	private Board board;
	
	@BeforeEach
	void setUp() throws Exception {
		coordWithShipNotSink = new Coordinate(0,2);
		coordWithShipSink = new Coordinate(0,0);
		coordEmpty = new Coordinate(0,1);
		board = new Board(10, false);
	}
	
	/**
	 * Use cases:
	 * 1. Shoot at a position without ship
	 * 2. Shoot at a position with a ship and does not sink
	 * 3. Shoot at a position with a ship and sinks it
	 */

	/**
	 * GIVEN a board and a position to shoot at
	 * WHEN shoots a position without ship
	 * THEN returns NO_DAMAGE and changes the square value shot to true
	 */
	@Test
	public void shootAtEmpty() {
		assertEquals(Damage.NO_DAMAGE, board.shootAt(coordEmpty));
		assertTrue(board.getInnerArray()[1][0].getShot());
	}
	
	/**
	 * GIVEN a board and a position to shoot at
	 * WHEN shoots a position with a ship and does not sink
	 * THEN returns SEVERE_DAMAGE and changes the square value shot to true
	 */
	@Test
	public void shootAtShipNoSink() {
		assertEquals(Damage.SEVERE_DAMAGE, board.shootAt(coordWithShipNotSink));
		assertTrue(board.getInnerArray()[2][0].getShot());
	}
	
	/**
	 * GIVEN a board and a position to shoot at
	 * WHEN shoots a position with a ship and does not sink
	 * THEN returns SEVERE_DAMAGE and changes the square value shot to true
	 */
	@Test
	public void shootAtShipSink() {
		assertEquals(Damage.MASSIVE_DAMAGE, board.shootAt(coordWithShipSink));
		assertTrue(board.getInnerArray()[0][0].getShot());
	}

}

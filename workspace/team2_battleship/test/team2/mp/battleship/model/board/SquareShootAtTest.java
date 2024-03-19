package team2.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.mp.battleship.model.board.Square.Damage;
import team2.mp.battleship.model.board.squares.Ship;
import team2.mp.battleship.model.board.squares.Water;

class SquareShootAtTest {

	// Attributes
	private Square square;
	private Ship submarine;
	private Ship destroyer;
	private Water water;
	
	@BeforeEach
	void setUp() throws Exception {
		square = new Square();
		submarine = new Ship(1);
		destroyer = new Ship(2);
		water = new Water();
	}

	
	/**
	 * Use cases:
	 * 1. Shot at the water
	 * 2. Shot at a submarine
	 * 3. Shot at a destroyer
	 * 4. Shot at the last position of a destroyer
	 */
	
	/**
	 * GIVEN square with water
	 * WHEN it is shot
	 * THEN returns NO_DAMAGE
	 */
	@Test
	void shotAtWater() {
		square.setContent(water);
		assertEquals(Damage.NO_DAMAGE, square.shootAt());
	}
	
	/**
	 * GIVEN square with a submarine
	 * WHEN it is shot
	 * THEN returns MASSIVE_DAMAGE
	 */
	@Test
	void shotAtSubmarine() {
		square.setContent(submarine);
		assertEquals(Damage.MASSIVE_DAMAGE, square.shootAt());
	}
	
	/**
	 * GIVEN square with destroyer
	 * WHEN it is shot (but not sunk)
	 * THEN returns SEVERE_DAMAGE
	 */
	@Test
	void shotAtDestroyerNotSink() {
		square.setContent(destroyer);
		assertEquals(Damage.SEVERE_DAMAGE, square.shootAt());
	}
	
	/**
	 * GIVEN squares with a destroyer
	 * WHEN it is shot and sunk
	 * THEN returns MASSIVE_DAMAGE
	 */
	@Test
	void shotAtDestroyerAndSink() {
		Square square2 = new Square();
		square.setContent(destroyer);
		square2.setContent(destroyer);
		square2.shootAt();
		
		assertEquals(Damage.MASSIVE_DAMAGE, square.shootAt());
	}

}

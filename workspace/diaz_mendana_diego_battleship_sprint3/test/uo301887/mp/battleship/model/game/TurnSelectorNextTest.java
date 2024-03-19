package uo301887.mp.battleship.model.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo301887.mp.battleship.model.player.Player;

class TurnSelectorNextTest {

	// Attribute
	private TurnSelector turnSelector;
	private Player human;
	private Player computer;
	
	@BeforeEach
	void setUp() throws Exception {
		human = new Player("A", 0, 0);
		computer = new Player("B", 0, 0);
		turnSelector = new TurnSelector(human, computer);
	}

	/**
	 * Use cases:
	 * 1. Two consecutive calls to the turnSelector
	 */
	
	/**
	 * GIVEN a turnSelector with two players
	 * WHEN uses next() twice
	 * THEN changes twice times the player
	 */
	@Test
	void turnSelectorTwoTimes() {
		if(human == turnSelector.next()) {
			assertTrue(computer == turnSelector.next());
			assertTrue(human == turnSelector.next());
		} else {
			assertTrue(human == turnSelector.next());
			assertTrue(computer == turnSelector.next());
		}
	}

}

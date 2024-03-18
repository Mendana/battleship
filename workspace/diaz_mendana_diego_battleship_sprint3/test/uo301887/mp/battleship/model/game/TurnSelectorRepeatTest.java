package uo301887.mp.battleship.model.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo301887.mp.battleship.model.player.Player;

class TurnSelectorRepeatTest {

	// Attribute
		private TurnSelector turnSelector;
		private Player human;
		private Player computer;
		
		@BeforeEach
		void setUp() throws Exception {
			human = new Player("A");
			computer = new Player("B");
			turnSelector = new TurnSelector(human, computer);
		}

		/**
		 * Use cases:
		 * 1. Repeat and next does not change the player
		 */
		
		/**
		 * GIVEN a turnSelector with two players
		 * WHEN uses repeat and next
		 * THEN does not change the player
		 */
		@Test
		void turnSelectorTwoTimes() {
			if(human == turnSelector.next()) {
				turnSelector.repeat();
				assertTrue(human == turnSelector.next());
			} else {
				turnSelector.repeat();
				assertTrue(computer == turnSelector.next());
			}
		}
}

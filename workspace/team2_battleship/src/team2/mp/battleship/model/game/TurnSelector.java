package team2.mp.battleship.model.game;

import java.util.Random;

import team2.mp.battleship.model.player.Player;
import uo.mp.util.check.ArgumentChecks;

class TurnSelector {
	
	// Attributes
	private Player userPlayer;
	private Player computerPlayer;
	private Player actualPlayer;

	/**
	 * Constructor with the players as parameters.
	 * 
	 * @param user, user player
	 * @param computer, computer player
	 * @throws IllegalArgumentException if any parameter is null
	 */
	public TurnSelector(Player user, Player computer) {
		ArgumentChecks.isNotNull(computer);
		ArgumentChecks.isNotNull(user);
		
		this.userPlayer = user;
		this.computerPlayer = computer;
		this.actualPlayer = null;
		
	}
	
	/**
	 * Returns the next player to play. The first time is random
	 * 
	 * It will alternate the players except if repeat() is called before
	 * 
	 * @return Player, player who is going to start the turn
	 */
	Player next() {
		if(actualPlayer == null) {
			actualPlayer = (new Random().nextInt(2) == 0)? userPlayer:computerPlayer;
		} else {
			repeat();
		}
		return actualPlayer;
	}
	
	/**
	 * Changes the value of the actual player so it has another turn
	 */
	void repeat() {
		actualPlayer = (actualPlayer == userPlayer)? computerPlayer:userPlayer;
	}

}


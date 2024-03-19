package uo301887.mp.battleship;

import uo301887.mp.battleship.console.ConsoleGameInteractor;
import uo301887.mp.battleship.console.ConsoleGamePresenter;
import uo301887.mp.battleship.interaction.RandomGameInteractor;
import uo301887.mp.battleship.model.game.Game;
import uo301887.mp.battleship.model.player.Player;

public class Main {

	private Game game;
	private boolean gameMode = false;

	public static void main(String[] args) {
		new Main()
			.configure(args)
			.run();
	}

	private boolean readDebugMode(String mode) {
		if (mode == null ||
				"DEBUG".equals(mode.toUpperCase()))
			return true;
		return false;
	}
	
	private Main configure(String[] args) {
		ConsoleGameInteractor gameInteractor = new ConsoleGameInteractor();
		RandomGameInteractor randGameInteractor = new RandomGameInteractor(10);
		
		Player user = new Player("User", 1, 1);
		user.setInteractor(gameInteractor);
		Player computer = new Player("Computer", 0, 0);
		computer.setInteractor(randGameInteractor);
		
		ConsoleGamePresenter presenter = new ConsoleGamePresenter();
		
		game = new Game( user, computer );
		game.setPresenter(presenter);
		gameMode = readDebugMode(args[0]);
		game.setDebugMode(gameMode);
		return this;
	}

	private void run() {
		game.play();
	}
}

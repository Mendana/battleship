package team2.mp.battleship;

import team2.mp.battleship.console.ConsoleGameInteractor;
import team2.mp.battleship.console.ConsoleGamePresenter;
import team2.mp.battleship.interaction.RandomGameInteractor;
import team2.mp.battleship.model.game.Game;
import team2.mp.battleship.model.player.Player;

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
		
		Player user = new Player("User", 1, 1, false);
		user.setInteractor(gameInteractor);
		Player computer = new Player("Computer", 1, 1, true);
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

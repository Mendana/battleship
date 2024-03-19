package uo301887.mp.battleship;

import uo301887.mp.battleship.gui.GUIContainer;
import uo301887.mp.battleship.gui.GUIGamePresenter;
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
		
		GUIContainer container = new GUIContainer(10);				
		GUIGamePresenter ggp = container.getPresenter();
		
		Player computer = new Player("The Machine", 0, 0);
		computer.setInteractor(new RandomGameInteractor(10));

		Player user = new Player("The Person", 1, 1);
		user.setInteractor(container.getInteractor());

		game = new Game( user, computer );
		gameMode = readDebugMode(args[0]);
		game.setDebugMode(gameMode);
		
		game.setPresenter( ggp );
		return this;
	}

	private void run() {
		game.play();
	}


}

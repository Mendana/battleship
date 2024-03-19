package uo301887.mp.battleship.model.game;

import uo.mp.util.check.ArgumentChecks;
import uo301887.mp.battleship.interaction.GamePresenter;
import uo301887.mp.battleship.model.player.*;
import uo301887.mp.battleship.model.board.*;
import uo301887.mp.battleship.model.board.Square.Damage;

public class Game {
	
	// Constant values
	/** Normal mode */
	public static final boolean NORMAL_MODE = false;
	
	/** Debug mode */
	public static final boolean DEBUG_MODE = true;
	
	/** Default size */
	public static final int DEFAULT_BOARD_SIZE = 10;
	
	
	// Attributes
	private boolean debugMode;		//Mode in which the game is going to be played (Normal/Debug)
	private Player human;
	private Player computer;
	private TurnSelector turnSelector; //Creo que va aquí
	private GamePresenter presenter; //Lo mismo que el anterior
	
	/**
	 * Constructor with the two players (human and computer) and the size of the board as parameters
	 * 
	 * @param human, Player that plays the game. The "real" player
	 * @param computer, Player that plays the game. It is like a "bot" player
	 * @param size, int with dimension of the board
	 * @throws IllegalArgumentException if the parameters are null or the dimension is < 10 or > 20
	 */
	public Game(Player human, Player computer, int size) {
		ArgumentChecks.isTrue(size >= 10 && size <= 20, " is an invalid argument");
		ArgumentChecks.isNotNull(computer);
		ArgumentChecks.isNotNull(human);
		setDebugMode(NORMAL_MODE);
		setHuman(human);
		setComputer(computer);
		turnSelector = new TurnSelector(human, computer);
		Board humanBoard = new Board(size, true);
		Board computerBoard = new Board(size, true);
		
		human.setMyShips(humanBoard);
		human.setOpponentShips(computerBoard);
		computer.setMyShips(computerBoard);
		computer.setOpponentShips(humanBoard);
	}
	
	/**
	 * Constructor with the two players (human and computer) as parameters. Creates the board with a default
	 * size of 10 squares per row and column
	 * 
	 * @param leftPlayer, Player that plays the game. The "real" player
	 * @param rightPlayer, Player that plays the game. It is like a "bot" player
	 * @throws IllegalArgumentException if the parameters are null
	 */
	public Game(Player leftPlayer, Player rightPlayer) {
		this(leftPlayer, rightPlayer, DEFAULT_BOARD_SIZE);		
	}
	
	/**
	 * This method sets the value of the gameMode
	 * 
	 * @param gameMode, boolean with true for debug mode and false for normal mode
	 */
	public void setDebugMode (boolean gameMode) {
		this.debugMode = gameMode;
	}

	/**
	 * This method is the game loop, for each turn it will happen once
	 * It shows both boards, checks the turn, shows the name of the turn´s player, shoots at the selected coordinate,
	 * prints the message of being shooting at the selected coordinate, prints if there was anything at the
	 * coordinate and checks if some has won
	 */
	public void play() {
		//Shows the boards		
		boolean gameOver = false;
		while(!gameOver) {
			//Checks the turn and does all the turn algorithm		

			if(turnSelector.next() == human) {
				presenter.showGameStatus(getHuman().getMyShips(), getHuman().getOpponentShips(), debugMode);
				playTurn(human);
			} else {
				playTurn(computer);
			}
			
			//Checks if the game has finished
			if(getHuman().getMyShips().isFleetSunk()) {
				gameOver = true;
				presenter.showWinner(getComputer());
				presenter.showGameOver();
			} else if(getComputer().getMyShips().isFleetSunk()){
				gameOver = true;
				presenter.showWinner(getHuman());
				presenter.showGameOver();
			}
		}
		
	}
	
	
	/**
	 * Sets the game presenter of the game.
	 * 
	 * @param arg, game presenter of the game
	 * @throws IllegalArgumentException if the arg is null
	 */
	public void setPresenter(GamePresenter arg) {
		ArgumentChecks.isNotNull(arg);
		this.presenter = arg;
	}
	
	/**
	 * Plays a turn 
	 * 
	 * @param player, players who is playing the turn
	 */
	private void playTurn(Player player) {
		presenter.showTurn(player);
		Coordinate coordinate = player.makeChoice();
		presenter.showShootingAt(coordinate);
		shootAt(player.shootAt(coordinate));
	}

	/**
	 * This method sets the human player
	 * @param human, HumanPlayer that is going to be playing the game
	 */
	private void setHuman(Player human) {
		this.human = human;
	}

	/**
	 * This method sets the cpu player
	 * @param computer, ComputerPlayer as the cpu playing against the player
	 */
	private void setComputer(Player computer) {
		this.computer = computer;
	}
	
	/**
	 * This method gets the value of the human player
	 * @return HumanPlayer, the human user who is playing
	 */
	private Player getHuman() {
		return human;
	}
	
	/**
	 * This method gets the value of the computer player
	 * @return ComputerPlayer, the computer player (the bot)
	 */
	private Player getComputer() {
		return computer;
	}
	
	/**
	 * Shoots to a selected coordinate and prints the message with the information of
	 * the result of the shot. If it hits, it has again the turn
	 * 
	 * @param damage, Damage info of the shot
	 */
	private void shootAt(Damage damage) {
		presenter.showShotMessage(damage);
		switch (damage) {
		case MASSIVE_DAMAGE: case SEVERE_DAMAGE:
			turnSelector.repeat();
		default:
			break;
		}
	}
}

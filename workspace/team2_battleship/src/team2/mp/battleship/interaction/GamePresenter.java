package team2.mp.battleship.interaction;

import team2.mp.battleship.model.board.Board;
import team2.mp.battleship.model.board.Coordinate;
import team2.mp.battleship.model.board.Square.Damage;
import team2.mp.battleship.model.player.Player;

public interface GamePresenter {

	/**
	 * Shows the game status (boards, original fleet, fleet left).
	 * 
	 * @param left, Board of the player
	 * @param right, Board of the computer
	 * @param gameMode, mode of play
	 */
	void showGameStatus(Board left, Board rigth, boolean gameMode);
	
	/**
	 * Informs the player if the game has finished with the message: GAME OVER!!!!
	 */
	void showGameOver();
	
	/**
	 * Shows the name of the winner of the game with the following format:
	 * The winner is <winner´s name>. Congratulations!!!
	 * 
	 * @param theWinner, player who was won
	 */
	void showWinner(Player theWinner);
	
	/**
	 * Shows the result of the shot with the following messages:
	 * Hit! Repeat --> Hits a ship
	 * Hit and Sunk! Repeat --> Hits and sunk a ship
	 * Miss! Change turn --> Fails the shot
	 * 
	 * @param impact, result of the shot
	 */
	void showShotMessage(Damage impact);
	
	/**
	 * Shows the player´s name whose turn it is with the following format
	 * Now, the turn is for player <Player´s name>
	 * 
	 * @param player, Player with the turn
	 */
	void showTurn(Player player);
	
	/**
	 * Displays a message with the coordinate selected as the objective of the shot with the following format
	 * Shooting at <Coordinate with family-friendly format>
	 * 
	 * @param coordinate, Coordinate where the player is shooting
	 */
	void showShootingAt(Coordinate coordinate);
}

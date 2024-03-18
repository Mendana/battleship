package uo301887.mp.battleship.console;

import uo301887.mp.battleship.interaction.GamePresenter;
import uo301887.mp.battleship.model.board.Board;
import uo301887.mp.battleship.model.board.Coordinate;
import uo301887.mp.battleship.model.board.Square.Damage;
import uo301887.mp.battleship.model.player.Player;

public class ConsoleGamePresenter implements GamePresenter{

	
	/**
	 * Shows the game status (boards, original fleet, fleet left).
	 * 
	 * @param left, Board of the player
	 * @param right, Board of the computer
	 * @param gameMode, mode of play
	 */
	@Override
	public void showGameStatus(Board left, Board rigth, boolean gameMode) {
		printHeader();
		printBoards(left, rigth, gameMode);
		
	}

	/**
	 * Informs the player if the game has finished with the message: GAME OVER!!!!
	 */
	@Override
	public void showGameOver() {
		System.out.println("GAME OVER!!!!");
	}

	/**
	 * Shows the name of the winner of the game with the following format:
	 * The winner is <winner´s name>. Congratulations!!!
	 * 
	 * @param theWinner, player who was won
	 */
	@Override
	public void showWinner(Player theWinner) {
		System.out.printf("The winner is %s. Congratulations!!!\n", theWinner.getName());		
	}

	/**
	 * Shows the result of the shot with the following messages:
	 * Hit! Repeat --> Hits a ship
	 * Hit and Sunk! Repeat --> Hits and sunk a ship
	 * Miss! Change turn --> Fails the shot
	 * 
	 * @param impact, result of the shot
	 */
	@Override
	public void showShotMessage(Damage impact) {
		System.out.println(damageToString(impact));		
	}

	/**
	 * Shows the player´s name whose turn it is with the following format
	 * Now, the turn is for player <Player´s name>
	 * 
	 * @param player, Player with the turn
	 */
	@Override
	public void showTurn(Player player) {
		System.out.printf("Now the turn is for the player %s \n", player.getName());		
	}

	/**
	 * Displays a message with the coordinate selected as the objective of the shot with the following format
	 * Shooting at <Coordinate with family-friendly format>
	 * 
	 * @param coordinate, Coordinate where the player is shooting
	 */	
	@Override
	public void showShootingAt(Coordinate coordinate) {
		System.out.printf("Shoot at %s... \n", coordinate.toUserString());
	}
	
	/**
	 * Prints the header of the boards
	 */
	private void printHeader() {
		System.out.println("        My ships                     OpponentShips");
		System.out.println("   A B C D E F G H I J            A B C D E F G H I J");
	}
	
	/**
	 * Prints the boards with the user-friendly format
	 * 
	 * @param left, user´s board
	 * @param right, computer´s board
	 * @param debugMode, boolean with true for using the debug mode (for normal games user false)
	 */
	private void printBoards(Board left, Board right, boolean debugMode) {
		for (int i = 0; i < left.getSize(); i++) {
			// Left Board
			printBoardRow(i, left, false);
			System.out.print("        ");
			
			//Right Board
			printBoardRow(i, right, debugMode);
			System.out.println();
		}
	}
	
	/**
	 * Prints a row of a board. It prints the information of the square of the board and a "|" for spacing
	 * 
	 * @param row, row to print
	 * @param board, board in which the method will work on
	 * @param debugMode, boolean with true for using the debug mode (for normal games user false)
	 */
	private void printBoardRow(int row, Board board, boolean debugMode) {
		char[][] charBoard = debugMode? board.getMinimalStatus():board.getFullStatus();
		
		if(row < 9) {
			System.out.print(" ");
		}
		System.out.print(row + 1 + "|");
		for (int j = 0; j < charBoard.length; j++) {
			System.out.print(charBoard[row][j] + "|");
		}
	}
	
	/**
	 * Returns a string with the information of the shot
	 * 
	 * @param damagem, Damage of the shot
	 * @return String with the damage info
	 */
	private String damageToString(Damage damage) {
		if(damage == Damage.MASSIVE_DAMAGE) {
			return "Hit and Sunk!. Repeat";
		} else if (damage == Damage.SEVERE_DAMAGE) {
			return "Hit! Repear";
		} else {
			return "Miss! Change turn";
		}
	}

	
}

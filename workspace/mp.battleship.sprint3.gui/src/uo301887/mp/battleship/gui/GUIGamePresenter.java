package uo301887.mp.battleship.gui;

import javax.swing.JOptionPane;

import uo301887.mp.battleship.interaction.GamePresenter;
import uo301887.mp.battleship.model.board.Board;
import uo301887.mp.battleship.model.board.Coordinate;
import uo301887.mp.battleship.model.board.Square.Damage;
import uo301887.mp.battleship.model.player.Player;


public class GUIGamePresenter implements GamePresenter {

	private Presenter presenterLeft; // user board
	private Presenter presenterRight; // computer board
	

	public GUIGamePresenter(BoardView viewLeft, BoardView viewRight) {

		if (presenterLeft == null) {
			presenterLeft = new Presenter();
			presenterLeft.setView(viewLeft);
			viewLeft.setPresenter(presenterLeft);
			presenterLeft.show();
		}
		if (presenterRight == null) {
			presenterRight = new Presenter();
			presenterRight.setView(viewRight);
			viewRight.setPresenter(presenterRight);
			presenterRight.show();
		}		
	}

	@Override
	public void showGameStatus(Board left, Board right, boolean debugMode) {
		presenterLeft.update( left.getFullStatus() );
		char[][] rightchars = (debugMode)?
				right.getFullStatus()
				:right.getMinimalStatus();
		presenterRight.update( rightchars );
		
	}

	
	  public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	
	@Override
	public void showWinner(Player winner) {
		presenterRight.setMessage("The winner is " 
				+ winner.getName()
				+ " Congratulations !!! ");
		
	}

	@Override
	public void showGameOver() {
		presenterLeft.setMessage("GAME OVER !!! ");		
	}

	@Override
	public void showTurn(Player player) {
		presenterRight.setMessage("Now, the turn is for the player " 
					+ player.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showShootingAt(Coordinate position) {
		presenterLeft.setMessage("Shooting at "  
				+ position.toUserString() );
	}

	@Override
	public void showShotMessage(Damage damage) {
		String message = null;
		switch ( damage ) {
		case NO_DAMAGE: message = "MISS!!! LOSE YOUR TURN ";
				break;
		case SEVERE_DAMAGE: message = "HIT!!! REPEAT";
				break;
		case MASSIVE_DAMAGE: message = "HIT AND SUNK!!! REPEAT";
				break;
		}
		presenterLeft.setMessage( message );
		
	}
	
}

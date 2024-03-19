package team2.mp.battleship.model.board.squares;

import team2.mp.battleship.model.board.Square.Damage;

public interface Target {

	 Damage shootAt();
	 char toChar();
	 char toFiredChar();
	 
}

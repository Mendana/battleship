package uo301887.mp.battleship.model.board.squares;

import uo301887.mp.battleship.model.board.Square.Damage;

public interface Target {

	 Damage shootAt();
	 char toChar();
	 char toFiredChar();
	 
}

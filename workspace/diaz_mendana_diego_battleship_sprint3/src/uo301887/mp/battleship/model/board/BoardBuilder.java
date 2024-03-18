package uo301887.mp.battleship.model.board;

import java.util.ArrayList;
import java.util.List;

import uo301887.mp.battleship.model.board.squares.Ship;
import uo301887.mp.battleship.model.board.squares.Water;

class BoardBuilder {

	static Square[][] build(int size, List<Ship> fleet) {
		Square[][] board = new Square[size][size];
		ArrayList<Ship> fleet2 = new ArrayList<>(fleet);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Square();
				board[i][j].setContent(new Water());
			}
		}
		
		board[6][4].setContent(fleet2.get(0));
		board[6][5].setContent(fleet2.get(0));
		board[6][6].setContent(fleet2.get(0));
		board[6][7].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[4][0].setContent(fleet2.get(0));
		board[4][1].setContent(fleet2.get(0));
		board[4][2].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[4][4].setContent(fleet2.get(0));
		board[4][5].setContent(fleet2.get(0));
		board[4][6].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[2][0].setContent(fleet2.get(0));
		board[2][1].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[2][3].setContent(fleet2.get(0));
		board[2][4].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[2][6].setContent(fleet2.get(0));
		board[2][7].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[0][0].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[0][2].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[0][4].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		board[0][6].setContent(fleet2.get(0));
		fleet2.remove(0);
		
		return board;
	}
}
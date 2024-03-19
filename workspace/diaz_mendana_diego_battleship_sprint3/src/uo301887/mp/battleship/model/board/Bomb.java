package uo301887.mp.battleship.model.board;

import java.util.ArrayList;

public class Bomb {
    private int remainingUses;

    public Bomb(int uses) {
        this.remainingUses = uses;
    }
    
    public int getRemainingUse() {
    	return this.remainingUses;
    }

    public void trigger() {
        if (remainingUses <= 0) {
            throw new IllegalStateException("Bomb has no remaining uses!");
        }
        remainingUses--;
    }

    public ArrayList<Coordinate> explode(Coordinate position, Board board) {
    	ArrayList<Coordinate> res= new ArrayList<Coordinate>();
        int row = position.getRow();
        int col = position.getCol();

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
            	if (i>=0 && i<10 && j>=0 && j<10 ) {
            		board.shootAt(new Coordinate(j, i));
            		res.add(new Coordinate(j,i));
            	}
            }
        }
        return res;
    }
}
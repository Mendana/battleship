package uo301887.mp.battleship.model.board;

import java.util.ArrayList;

public class LineDestroyer {

	private int remainingUses;

    public LineDestroyer(int uses) {
        this.remainingUses = uses;
    }
    
    public int getRemainingUse() {
    	return this.remainingUses;
    }

    public void trigger() {
        if (remainingUses <= 0) {
            throw new IllegalStateException("LineDestroyer has no remaining uses!");
        }
        remainingUses--;
    }
    
    public ArrayList<Coordinate> explode(Coordinate position, Board board) {
    	ArrayList<Coordinate> res= new ArrayList<Coordinate>();
        int row = position.getRow();
        int col = position.getCol();

        for (int i=0; i<10; i++) {
            board.shootAt(new Coordinate(i, col));
            res.add(new Coordinate(i,col)); 
            board.shootAt(new Coordinate(row, i));
            res.add(new Coordinate(row,i));
        }
        return res;
    }
}
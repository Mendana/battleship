package team2.mp.battleship.model.board;

import java.util.List;

/*public class BoardBuilder {

	static Square[][] build(int size, List<Ship> fleet){
		System.out.println("Would you like to add a new boat?");
		Square[][] board = new Square[size][size];
			
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Square();
				board[i][j].setContent(new Water());
			}
		}
		
		return board;
		
	}
}*/

import java.util.Scanner;

import team2.mp.battleship.model.board.Coordinate.Direction;
import team2.mp.battleship.model.board.squares.Ship;
import team2.mp.battleship.model.board.squares.Water;

public class BoardBuilder {

    private static int BOARD_SIZE = 0;
    private static Scanner scanner = new Scanner(System.in);

    static Square[][] build(int size, List<Ship> fleet) {
        BOARD_SIZE = size;
        Square[][] board = new Square[size][size];

        // Initialize the board with water
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square();
                board[i][j].setContent(new Water());
            }
        }

        // Place ships
        for (Ship ship : fleet) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place the ship of size " + ship.size() + ". (Format: x y Direction[NORTH, SOUTH, EAST, WEST])");
                int x = readInt() - 1; // Adjust for 0-based indexing
                int y = readInt() - 1;
                Direction direction = readDirection();

                Coordinate coord = new Coordinate(x, y);
                placed = tryPlaceShip(ship, coord, direction, board);
                if (!placed) {
                    System.out.println("Invalid placement, please try again.");
                }
            }
        }

        return board;
    }

    // Reads an integer from the user, repeats the prompt if the input is not an integer.
    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a number.");
            scanner.next(); // Discard non-integer input
        }
        return scanner.nextInt();
    }

    // Reads a direction from the user, repeats the prompt if the input is not a valid direction.
    private static Direction readDirection() {
        String input = scanner.next().toUpperCase();
        while (!input.equals("NORTH") && !input.equals("SOUTH") && !input.equals("EAST") && !input.equals("WEST")) {
            System.out.println("Invalid direction, please enter NORTH, SOUTH, EAST, or WEST.");
            input = scanner.next().toUpperCase();
        }
        return Direction.valueOf(input);
    }

    private static boolean tryPlaceShip(Ship ship, Coordinate coord, Direction direction, Square[][] board) {
        Coordinate currentCoord = coord;
        for (int i = 0; i < ship.size(); i++) {
            if (!isInBoard(currentCoord) || !(board[currentCoord.getRow()][currentCoord.getCol()].getContent() instanceof Water)) {
                return false;
            }
            if (!isNotSurrounded(currentCoord, board)) {
                return false;
            }
            currentCoord = currentCoord.go(direction);
        }

        currentCoord = coord;
        for (int i = 0; i < ship.size(); i++) {
            board[currentCoord.getRow()][currentCoord.getCol()].setContent(ship);
            currentCoord = currentCoord.go(direction);
        }

        return true;
    }

    private static boolean isInBoard(Coordinate coord) {
        if(coord.getCol() < 0 || coord.getCol() >= BOARD_SIZE
                || coord.getRow() < 0 || coord.getRow() >= BOARD_SIZE) {
            return false;
        }
        return true;
    }
    
    private static boolean isNotSurrounded(Coordinate coord, Square[][] board) {
        if(isInBoard(coord.go(Direction.NORTH)) && !isFreePositon(coord.go(Direction.NORTH), board)){
            return false;
        }
        if(isInBoard(coord.go(Direction.SOUTH)) && !isFreePositon(coord.go(Direction.SOUTH), board)){
            return false;
        }
        if(isInBoard(coord.go(Direction.EAST)) && !isFreePositon(coord.go(Direction.EAST), board)){
            return false;
        }
        if(isInBoard(coord.go(Direction.WEST)) && !isFreePositon(coord.go(Direction.WEST), board)){
            return false;
        }
        return true;
    }
    
    private static boolean isFreePositon(Coordinate coord, Square[][] board) {
		return !(board[coord.getRow()][coord.getCol()].getContent() instanceof Ship);
	}
}
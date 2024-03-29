package team2.mp.battleship.console;

import team2.mp.battleship.interaction.GameInteractor;
import team2.mp.battleship.model.board.Coordinate;
import uo.mp.util.console.Console;

public class ConsoleGameInteractor implements GameInteractor {

	/**
	 * Read values from keyboard. First, a letter for the column; then, a number for
	 * the row. When read, it transforms this values into indexes in the inner array
	 * and builds a coordinate object.
	 * 
	 * @return the coordinate corresponding to the values read from standard input
	 */
	@Override
	public Coordinate getTarget() {
		System.out.print("Col (letter): ");

		char caracter = Console.readChar();
		caracter = (caracter + " ").toUpperCase().charAt(0);

		int x = caracter - 'A';

		System.out.print("Row (number): ");

		int y = Console.readInt() - 1;

		return new Coordinate(x, y);
	}

}

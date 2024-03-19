package team2.mp.battleship.model.player;

import java.util.ArrayList;

import java.util.List;

import team2.mp.battleship.interaction.GameInteractor;
import team2.mp.battleship.model.board.Board;
import team2.mp.battleship.model.board.Bomb;
import team2.mp.battleship.model.board.Coordinate;
import team2.mp.battleship.model.board.LineDestroyer;
import team2.mp.battleship.model.board.Square.Damage;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.console.Console;


public class Player {

	// Attributes
	private String name;
	private Board myShips;
	private Board myOpponentShips;
	private GameInteractor gameInteractor;
	private List<Coordinate> shotCoordinates = new ArrayList<>();
	private Bomb bomb; 
	private LineDestroyer lineDestroyer;

	/**
	 * Constructor with the name parameter
	 * 
	 * @param name, String with the name of the player
	 * @throws IllegalArgumentException if the name is blank or null
	 */
	public Player(String name,int numberBombs,int numberLineDestroyer) {
		ArgumentChecks.isNotNull(name);
		ArgumentChecks.isNotBlank(name);
		setName(name);
		bomb=new Bomb(numberBombs);
		lineDestroyer= new LineDestroyer(numberLineDestroyer);
		
	}
	/**
	 * This method returns the player´s name
	 * 
	 * @return String with the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns the value board (parameter) to the game board of the player
	 * 
	 * @param board, matrix of integers to set the player´s game board
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setMyShips(Board board) {
		ArgumentChecks.isNotNull(board);
		this.myShips = board;
	}

	/**
	 * Assigns the value board (parameter) to the game board of the opponent player
	 * 
	 * @param board, matrix of integers to set the opponents´s game board
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setOpponentShips(Board board) {
		ArgumentChecks.isNotNull(board);
		this.myOpponentShips = board;
	}

	/**
	 * Shoots at a given position of opponent´s board. If it hits any ship the method returns
	 * SEVERE_DAMAGE if it is not sunk or MASSIVE_DAMAGE if it is sunk. If it does not hit
	 * any ship it returns MISSED_SHOT
	 * 
	 * @param position, Coordinate where player is going to shoot at
	 * @return Damage of the shot with the previous information
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public Damage shootAt(Coordinate position) {
		ArgumentChecks.isNotNull(position);
		return getOpponentShips().shootAt(position);
	}

	/**
	 * Returns the player´s board
	 * 
	 * @return Board, player´s board
	 */
	public Board getMyShips() {
		return myShips;
	}

	/**
	 * Returns the opponent´s board
	 * 
	 * @return Board, opponent´s Board
	 */
	public Board getOpponentShips() {
		return myOpponentShips;
	}

	/**
	 * Returns true if enemy´s fleet is sunk
	 * 
	 * @return boolean with true if enemy´s fleet is sunk or false if not
	 */
	public boolean hasWon() {
		return getOpponentShips().isFleetSunk();
	}

	/**
	 * Reads the coordinates written in the console and returns a coordinate object with the values
	 * 
	 * @return Coordinate with the values written by the user in the screen
	 */
	public Coordinate makeChoice() {
		do {
			if (this.bomb.getRemainingUse()>0 && this.lineDestroyer.getRemainingUse()>0) {
				System.out.println("------Bonus options-----");
				System.out.println("Bomb ------------ Press #");
				System.out.println("LineDestroyer --- Press @");
				System.out.print("For using the press the key: ");


				char caracter = Console.readChar();
				Coordinate coordinateToShot = getGameInteractor().getTarget();
				if (caracter == '#') {
					shotCoordinates.addAll(this.useBomb(coordinateToShot));
					return coordinateToShot;
				}
				else if (caracter == '@') {
					shotCoordinates.addAll(this.useLineDestroyer(coordinateToShot));
					return coordinateToShot;
				}
				
				else {
					if(!shotCoordinates.contains(coordinateToShot)) {
						shotCoordinates.add(coordinateToShot);
						return coordinateToShot;
					}
				}
				
			}
			else if (this.bomb.getRemainingUse()>0) {
				System.out.println("Do you want to use Bomb ?");
				System.out.print("Bomb : press #");


				char caracter = Console.readChar();
				Coordinate coordinateToShot = getGameInteractor().getTarget();
				if (caracter == '#') {
					shotCoordinates.addAll(this.useBomb(coordinateToShot));
					return coordinateToShot;
				}
				else {
					if(!shotCoordinates.contains(coordinateToShot)) {
						shotCoordinates.add(coordinateToShot);
						return coordinateToShot;
					}
				}
			}
			else if (this.lineDestroyer.getRemainingUse()>0) {
				System.out.println("Do you want to use line destroyer ?");
				System.out.print("LineDestroyer : press @");


				char caracter = Console.readChar();
				Coordinate coordinateToShot = getGameInteractor().getTarget();
				if (caracter == '@') {
					shotCoordinates.addAll(this.useLineDestroyer(coordinateToShot));
					return coordinateToShot;
				}
				
				else {
					if(!shotCoordinates.contains(coordinateToShot)) {
						shotCoordinates.add(coordinateToShot);
						return coordinateToShot;
					}
				}
			}
			else {
				Coordinate coordinateToShot = getGameInteractor().getTarget();

				
				if(!shotCoordinates.contains(coordinateToShot)) {
					shotCoordinates.add(coordinateToShot);
					return coordinateToShot;
				}
				
			}
			
			
		} while (true);
	}
	
	/**
	 * Adds the gameInteractor for the game
	 * 
	 * @param arg, GameInteractor for the game
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setInteractor(GameInteractor arg) {
		ArgumentChecks.isNotNull(arg);
		this.gameInteractor = arg;
	}
	
	/**
	 * Sets the value of the name of the player
	 * 
	 * @param name, String with the name of the player
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the value of the gameInteractor
	 * 
	 * @return GameInteractor of the player
	 */
	GameInteractor getGameInteractor() {
		return this.gameInteractor;
	}
	
	public void getBomb(Bomb bomb) {
        this.bomb = bomb;
    }



    public ArrayList<Coordinate> useBomb(Coordinate position) {
    	ArrayList<Coordinate> res= new ArrayList<Coordinate>();
        if (bomb.getRemainingUse()>0) {
            bomb.trigger();
            res=bomb.explode(position,this.myOpponentShips);
        } else {
            System.out.println("No bomb available for this player!");
        }
        return res;
    }
    
    public ArrayList<Coordinate> useLineDestroyer(Coordinate position) {
    	ArrayList<Coordinate> res= new ArrayList<Coordinate>();
        if (lineDestroyer.getRemainingUse()>0) {
        	lineDestroyer.trigger();
            res=lineDestroyer.explode(position,this.myOpponentShips);
        } else {
            System.out.println("No bomb available for this player!");
        }
        return res;
    }


}
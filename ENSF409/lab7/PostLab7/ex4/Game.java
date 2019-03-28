import java.io.IOException;
//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Starts the Tic-Tac-Toe game
 * @author M. Moshirpour, Michael Jeremy Olea
 * @version 1.0
 * @since March 24th, 2019
 */
public class Game implements Constants, Runnable {

	/**
	 * Object of class Board that holds the current game
	 */
	private Board theBoard;
	/**
	 * Object of class used to start and run the rules of the game
	 */
	private Referee theRef;

	/**
	 * Constructor for the game that constructs the Board
	 */
    public Game() {
		theBoard  = new Board();
	}
	
	/**
	 * Assigns the Referee for the game and starts the game
	 * @param r the Referee to be assinged to the game
	 * @throws IOException Exception in case of bad input/output
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
		theRef.setBoard(theBoard);
		theRef.getxPlayer().setBoard(theBoard);
		theRef.getoPlayer().setBoard(theBoard);
	}
	
	public void run() {
		theRef.runTheGame();
	}
}

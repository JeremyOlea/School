
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Starts the Tic-Tac-Toe game
 * @author M. Moshirpour, Michael Jeremy Olea
 * @version 1.0
 * @since January 31st, 2019
 */
public class Game implements Constants {

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
    public Game( ) {
        theBoard  = new Board();
	}
	
	/**
	 * Assigns the Referee for the game and starts the game
	 * @param r the Referee to be assinged to the game
	 * @throws IOException Exception in case of bad input/output
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	/**
	 * Collects information of players to run the game
	 * @param args Command line arguments
	 * @throws IOException Exception in case of bad input/output
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}

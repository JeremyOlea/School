/**
 * Runs and controls the game.
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since January 31st, 2019
 */
public class Referee {
    /**
     * Player that uses x mark
     */
    public Player xPlayer;
    /**
     * Player that uses o mark
     */
    public Player oPlayer;
    /**
     * the board used for the current game
     */
    public Board board;

    /**
     * Constructor for Referee object
     */
    Referee() {
       // xPlayer = new Player();
        //oPlayer = new Player();
        board = new Board();
    }

    /**
     * Starts the game by letting x player go first
     */
    public void runTheGame() {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        board.display();
        xPlayer.play();
    }

    /**
     * Assigns board used for current game
     * @param board Object of class Board used for current game
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Assigns Player o for the current game
     * @param oPlayer Object of class Player used for current game
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Assigns Player x for the current game
     * @param xPlayer Object of class Plater used for current game
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}
import java.util.*;

/**
 * Controls Player operations
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since January 31st, 2019
 */
abstract class Player implements Constants {

    /**
     * Name of player
     */
    protected String name;
    /**
     * the board that the player will play on
     */
    protected Board board;
    /**
     * the Player object that is assigned as the Player's opponent
     */
    protected Player opponent;
    /**
     * the Mark that the player will use
     */
    protected char mark;

    /**
     * Constructor for the player
     */
    abstract protected void play();
    abstract protected void makeMove();
    Player() {
        
    }

    /**
     * Constructor for player that initializes the name and mark of the player
     * @param name the name of the player
     * @param letter the mark the player will use
     */
    Player(String name, char letter) {
        this.name = name;
        mark = letter;
    }

    /**
     * Assigns the player a board to play on
     * @param board the board that the player will play on
     */
    protected void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Assigns the opponent of the player
     * @param  player the opponent of the player
     */
    protected void setOpponent(Player player) {
        opponent = player;
    }
}


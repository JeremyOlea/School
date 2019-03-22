import java.util.*;

/**
 * Controls Player operations
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since January 31st, 2019
 */
public class Player implements Constants {

    /**
     * Name of player
     */
    private String name;
    /**
     * the board that the player will play on
     */
    private Board board;
    /**
     * the Player object that is assigned as the Player's opponent
     */
    private Player opponent;
    /**
     * the Mark that the player will use
     */
    private char mark;

    /**
     * Constructor for the player
     */
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
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Assigns the opponent of the player
     * @param  player the opponent of the player
     */
    public void setOpponent(Player player) {
        opponent = player;
    }

    /**
     * Allows player to make a move and controls the opponent player's turn
     */
    public void play() {
        if(!board.xWins() && !board.oWins() && !board.isFull()) {
            makeMove();
            board.display();
            if(board.xWins() || board.oWins())
                System.out.printf("THE GAME IS OVER: %s is the winner!\n", name);
            else
                opponent.play();
        }
        else
            System.out.printf("Game ends in a draw!");
    }

    /**
     * Asks Player to input a position on the board to place their mark
     */
    public void makeMove() {
        int row, col;
        int isValid = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.printf("%s, what row should you next X be placed in?\n", name);
            row = keyboard.nextInt();
            System.out.printf("%s, what column should you next X be placed in?\n", name);
            col = keyboard.nextInt();
            if(row >= 0 && row <= 2 && col >= 0 && col <= 2)
                isValid = 1;

            if(isValid == 0)
                System.out.printf("Invalid row and column. Please try again\n");
            else if (board.getMark(row,col) == LETTER_X || board.getMark(row,col) == LETTER_O) {
                System.out.printf("Row %d, Column %d already taken. Please try again\n", row, col);
                isValid = 0;
            }
        }while(isValid ==  0);
        board.addMark(row, col, mark);
    }
}


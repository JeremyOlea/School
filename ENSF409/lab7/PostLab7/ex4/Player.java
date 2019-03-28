import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.*;

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

    private Socket aSocket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    /**
     * Constructor for the player
     */
    Player() {
        
    }

    /**
     * Constructor for player that initializes the name and mark of the player
     * @param s the socket used to communicate to client
     * @param letter the mark the player will use
     */
    Player(Socket s, char letter) {
        aSocket = s;
        mark = letter;
        try {
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter(aSocket.getOutputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Assigns the player a board to play on
     * @param board the board that the player will play on
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * getter for the name of the player
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns the opponent of the player
     * @param  player the opponent of the player
     */
    public void setOpponent(Player player) {
        opponent = player;
    }

    /**
     * Sends string to Client using the PrintWriter
     * @param send the input to be sent to Client
     */
    public void sendString(String send) {
        socketOut.println(send);
        socketOut.flush();
    }

    /**
     * Asks user to enter their name
     */
    public void getPlayerName() {
        try {
            sendString("Please enter name of '" + mark + "' player: \0");
            name = socketIn.readLine();
            while(name == null) {
                sendString("Please try again: \0");
                name = socketIn.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * displays the board to both players
     * @param board a string containing the board
     */
    public void displayBoard(String board) {
        sendString(board);
        opponent.sendString(board);
    }

    /**
     * Prints the result of the game
     * @param type variable that determines which message to print
     */
    public void printGameResult(int type) {
        String b = "";
        if(type == 0) {
            b = board.display();
            displayBoard(b);
            sendString("THE GAME IS OVER: " + name + " is the winner! \0");
            opponent.sendString("THE GAME IS OVER: " + name + " is the winner! \0");
            opponent.sendString("QUIT");
            sendString("QUIT");
        } else if(type == 1) {
            sendString("THE GAME IS OVER: Game ends in a draw! \0");
            opponent.sendString("THE GAME IS OVER: Game ends in a draw! \0");
            opponent.sendString("QUIT");
            sendString("QUIT");
        }
    }

    /**
     * Allows player to make a move and controls the opponent player's turn
     */
    public void play() {
        String b = board.display();
        displayBoard(b);
        if(!board.xWins() && !board.oWins() && !board.isFull()) {
            makeMove();
            if(board.xWins() && mark == LETTER_X || board.oWins() && mark == LETTER_O) {
                printGameResult(0);
            }
            else
                opponent.play();
        }
        else {
            printGameResult(1);
        }
            
    }

    /**
     * Asks Player to input a position on the board to place their mark
     */
    public void makeMove() {
        int row = -1;
        int col = -1;
        int isValid = 0;
        do {
            try {
                sendString(name + ", what row should you next X be placed in? \0");
                row = Integer.parseInt(socketIn.readLine());
                sendString(name + ", what column should you next X be placed in? \0");
                col = Integer.parseInt(socketIn.readLine());
            } catch(IOException e) {
                e.printStackTrace();
            }
            if(row >= 0 && row <= 2 && col >= 0 && col <= 2)
                isValid = 1;

            if(isValid == 0)
                sendString("INVALID: row and/or column does not exist. Please try again \0\n");
            else if (board.getMark(row,col) == LETTER_X || board.getMark(row,col) == LETTER_O) {
                sendString("INVALID: Row" + row + ", Column " + col + " already taken. Please try again \0\n");
                isValid = 0;
            }
        }while(isValid ==  0);
        board.addMark(row, col, mark);
    }
}


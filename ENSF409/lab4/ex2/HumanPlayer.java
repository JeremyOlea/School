import java.util.*;

public class HumanPlayer extends Player{

    HumanPlayer(String name, char letter) {
        this.name = name;
        mark = letter;
    }

    /**
     * Allows player to make a move and controls the opponent player's turn
     */
    protected void play() {
        if(!board.xWins() && !board.oWins() && !board.isFull()) {
            makeMove();
            System.out.println();
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
    protected void makeMove() {
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
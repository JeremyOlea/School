public class RandomPlayer extends Player{
    public RandomPlayer() {}

    RandomPlayer(String name, char letter) {
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
        RandomGenerator ran = new RandomGenerator();
        int isValid = 0;
        do {
            row = ran.discrete(0,2);
            col = ran.discrete(0,2);
            if (board.getMark(row,col) == LETTER_X || board.getMark(row,col) == LETTER_O) {
                isValid = 0;
            }
            else
                isValid = 1;
        }while(isValid == 0);
        board.addMark(row, col, mark);
    }
}
import java.util.Scanner;

// Outline of Program in Pseudocode Comments
// 1) Clear the board and set the Player to X (since X always moves first)
// 2) Get the coordinates for the move which should be 1-3 for the row and column
// 3a) Convert the player move to the array indices (which are 0-2) by subtracting 1 from the row and column.(As a programmer you always start at 0) !
// 3b) Loop (through steps 2 and 3) until the converted player coordinates are a valid move
// 4) Place the current player's mark on the board (X or O).
// 5) If appropriate, check for a win or tie. If there is a win or tie, announce it, then prompt the players to play again or exit.
// 6) If not, toggle the player for the next move (X becomes O, O becomes X).

public class TicTacToe {
    // Declare constants for the board dimensions
    private static final int ROWS = 3;
    private static final int COLS = 3;
    // Declare 2D game board
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    private static void clearBoard() // sets all the board elements to a space
    {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() // for looping through the array and printing it out in an organized way
    {
        System.out.printf(" %s | %s | %s %n", board[0][0], board[0][1], board[0][2]);
        System.out.println("---+---+---");
        System.out.printf(" %s | %s | %s %n", board[1][0], board[1][1], board[1][2]);
        System.out.println("---+---+---");
        System.out.printf(" %s | %s | %s %n", board[2][0], board[2][1], board[2][2]);
    }

    private static boolean isValidMove(int row, int col) // returns true if there is a space " " at the proposed move coordinates which means it's a legal move
    {
        return board[row][col].equals(" ");
    }

    private static boolean isRowWin(String player) // checks for a row win for the specified player
    {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) // checks for a column win for the specified player
    {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagWin(String player) // checks for a diagonal win for the specified player
    {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }
    private static boolean isWin(String player) // checks to see if there is a win state on the current board for the specified player (X or O)
    {
        if(isColWin(player) || isRowWin(player) || isDiagWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isTie() // checks for a tie condition
    {
        for(int row = 0; row < ROWS; row ++)
        {
            for(int col = 0; col < COLS; col ++)
            {
                if(board[row][col].equals (" "))
                {
                    return false;
                }
            }
        }
        return true;
    }
}



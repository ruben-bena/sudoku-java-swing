public class Main {

    public static void main(String[] args) {
        
        SudokuGame sg = new SudokuGame();
        System.out.println(sg);
    }
}

class SudokuGame {

    private int[][] board;

    public SudokuGame() {

        board = new int[9][9];
        fillBoardWithRandomNum();
    }

    // This is unrelated to how sudoku works, it just fills it with random numbers
    public void fillBoardWithRandomNum() {

        for (int row=0 ; row<board.length ; row++) {
            for (int col=0 ; col<board[row].length ; col++) {

                board[row][col] = (int) (1 + Math.random() * 8);
            }
        }
    }

    @Override
    public String toString() {

        String result = "";
        String betweenRows = "+---+---+---+---+---+---+---+---+---+";

        result += betweenRows + "\n";

        for (int row=0 ; row<board.length ; row++) {

            String rowString = "";
            for (int col=0 ; col<board[row].length ; col++) {

                rowString += String.format("| %1d ", board[row][col]);
            }

            result += rowString + "|\n" + betweenRows + "\n";
        }

        return result;
    }
}

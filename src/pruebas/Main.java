import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        SudokuGame sg = new SudokuGame();
        System.out.println(sg);

        // random board should give invalid board
        sg.isBoardValid();

        // setting predefined board to test isBoardValid()
        sg.setValidBoard();
        System.out.println(sg);
        sg.isBoardValid();
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

    public boolean isBoardValid() {

        // check rows
        for (int row=0 ; row<9 ; row++) {

            ArrayList<Integer> numInRow = new ArrayList<Integer>();
            for (int col=0 ; col<9 ; col++) {

                if (numInRow.contains(board[row][col])) {
                    System.out.println(String.format("Invalid board! row(%1d) contains number(%1d) more than once.", row, board[row][col]));
                    return false;
                }
                numInRow.add(board[row][col]);
            }
        }

        // check cols
        for (int col=0 ; col<9 ; col++) {

            ArrayList<Integer> numInCol = new ArrayList<Integer>();
            for (int row=0 ; row<9 ; row++) {

                if (numInCol.contains(board[row][col])) {
                    return false;
                }
                numInCol.add(board[row][col]);
            }
        }

        // check 3x3 groups
        // TODO: this does not work properly -> an invalid group is given but does not recognize it
        for (int rowGroup=1 ; rowGroup<4 ; rowGroup++) {
            for (int colGroup=1 ; colGroup<4 ; colGroup++) {

                // check inside the group
                ArrayList<Integer> numInGroup = new ArrayList<Integer>();
                for (int row=1 ; row<4 ; row++) {
                    for (int col=1 ; col<1 ; col++) {

                        int num = board[row * rowGroup - 1][col * colGroup -1];
                        if (numInGroup.contains(num)) {
                            System.out.println(String.format("Invalid board! group(%1d,%1d) contains number(%1d) more than once.", rowGroup, colGroup, board[row][col]));
                            return false;
                        }
                        numInGroup.add(num);
                    }
                }
            }
        }

        return true;
    }

    public void setValidBoard() {

        // valid board
        // board = new int[][] {
        //     {1,2,3, 4,5,6, 7,8,9},
        //     {4,5,6, 7,8,9, 1,2,3},
        //     {7,8,9, 1,2,3, 4,5,6},

        //     {2,3,1, 5,6,4, 8,9,7},
        //     {5,6,4, 8,9,7, 2,3,1},
        //     {8,9,7, 2,3,1, 5,6,4},

        //     {3,1,2, 6,4,5, 9,7,8},
        //     {6,4,5, 9,7,8, 3,1,2},
        //     {9,7,8, 3,1,2, 6,4,5}
        // };

        // invalid board (groups with repeated numbers)
        board = new int[][] {
            {1,2,3, 4,5,6, 7,8,9},
            {4,5,6, 7,8,9, 1,2,3},
            {7,8,9, 1,2,3, 4,5,6},

            {2,3,1, 5,6,4, 8,9,7},
            {5,6,4, 8,9,7, 2,3,1},
            {3,1,2, 6,4,5, 9,7,8},
            
            {8,9,7, 2,3,1, 5,6,4},
            {6,4,5, 9,7,8, 3,1,2},
            {9,7,8, 3,1,2, 6,4,5}
        };
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

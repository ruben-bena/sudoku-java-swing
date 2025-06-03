import java.util.ArrayList;
import java.util.Collections;

public class SudokuGenerator {

    private SudokuGenerator() {}

    public static SudokuBoard generateSolvedBoard() {

        SudokuBoard board = new SudokuBoard();

        fillBoard(board);

        return board;
    }

    public static void solveBoard(SudokuBoard board) {

        fillBoard(board);
    }

    public static boolean fillBoard(SudokuBoard board) {

        return fillBoard(board, 0, 0);
    }

    private static boolean fillBoard(SudokuBoard board, int i, int j) {

        ArrayList<Integer> numArray = generateArrayWithRandomNum();

        for (int num : numArray) {

            if (board.getCell(i, j).getValue() == 0) {
                board.getCell(i, j).setValue(num);
            }

            if (board.validateBoard()) {
                
                // Base case
                if (i == 8 && j == 8) {
                    return true;
                }

                // Next index pair
                int nextI = i;
                int nextJ = j + 1;
                if (nextJ > 8) {
                    nextJ = 0;
                    nextI++;
                }

                if (fillBoard(board, nextI, nextJ)) {
                    return true;
                }
            }

            // if number not valid, delete it from cell (in case we backtrack)
            board.getCell(i, j).setValue(0);
        }

        return false;
    }

    public static ArrayList<Integer> generateArrayWithRandomNum() {

        ArrayList<Integer> randomNum = new ArrayList<Integer>();
        for (int i=1 ; i<10 ; i++) {
            randomNum.add(i);
        }
        Collections.shuffle(randomNum);

        return randomNum;
    }

    // uses generateSolvedSudoku() and then substract some numbers keeping 1 valid solution
    public static SudokuBoard generateUnsolvedBoard(int deletedCells) {
        SudokuBoard board = SudokuGenerator.generateSolvedBoard();

        int counter = 0;
        do {

            int i = (int) (Math.random() * 9);
            int j = (int) (Math.random() * 9);
            if (board.getCell(i, j).getValue() != 0) {

                board.getCell(i, j).setValue(0);
                board.getCell(i, j).setCanBeChanged(true);
                counter++;
            }

        } while (counter < deletedCells);

        return board;
    }
}

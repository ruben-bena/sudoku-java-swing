public class SudokuGenerator {

    private SudokuGenerator() {}

    public static SudokuBoard generateSolvedBoard() {
        return new SudokuBoard();
    }

    // uses generateSolvedSudoku() and then substract some numbers keeping 1 valid solution
    public static SudokuBoard generateUnsolvedBoard() {
        return new SudokuBoard();
    }
}

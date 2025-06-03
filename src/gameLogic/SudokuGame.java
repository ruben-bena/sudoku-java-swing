public class SudokuGame {

    private SudokuBoard board;

    public SudokuGame() {

        this.board = new SudokuBoard();
    }

    public SudokuBoard getBoard() {
        
        return board;
    }

    public void setBoard(SudokuBoard board) {
        
        this.board = board;
    }
}
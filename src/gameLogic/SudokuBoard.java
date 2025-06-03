import java.util.ArrayList;

public class SudokuBoard {

    private SudokuCell[][] board;

    public SudokuBoard() {

        this.board = new SudokuCell[9][9];
        for (int i=0 ; i<9 ; i++) {
            for (int j=0 ; j<9 ; j++) {

                board[i][j] = new SudokuCell();
            }
        }
    }

    public SudokuCell[] getRow(int i) {

        SudokuCell[] row = new SudokuCell[9];
        for (int j=0 ; j<9 ; j++) {
            row[j] = board[i][j];
        }
        return row;
    }

    public SudokuCell[] getCol(int j) {

        SudokuCell[] col = new SudokuCell[9];
        for (int i=0 ; i<9 ; i++) {
            col[i] = board[i][j];
        }
        return col;
    }

    public SudokuCell[] getGroup(int groupRow, int groupCol) {

        /*
         * Index permutations:
         * 
         * 00 01 02
         * 10 11 12
         * 20 21 22
         */

        SudokuCell[] group = new SudokuCell[9];
        int index = 0;
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {

                group[index] = board[i+3*groupRow][j+3*groupCol];
                index++;
            }
        }

        return group;
    }

    public boolean validateBoard() {

        // Rows
        for (int i=0 ; i<9 ; i++) {

            ArrayList<Integer> rowValues = new ArrayList<Integer>();
            for (SudokuCell cell : getRow(i)) {

                if (rowValues.contains(cell.getValue())) {
                    return false;
                }
                if (cell.getValue() != 0) {
                    rowValues.add(cell.getValue());
                }
            }
        }            

        // Cols
        for (int j=0 ; j<9 ; j++) {

            ArrayList<Integer> colValues = new ArrayList<Integer>();
            for (SudokuCell cell : getCol(j)) {

                if (colValues.contains(cell.getValue())) {
                    return false;
                }
                if (cell.getValue() != 0) {
                    colValues.add(cell.getValue());
                }
            }
        } 

        // Groups
        for (int groupRow=0 ; groupRow<3 ; groupRow++) {
            for (int groupCol=0 ; groupCol<3 ; groupCol++) {

                ArrayList<Integer> groupValues = new ArrayList<>();
                for (SudokuCell cell : getGroup(groupRow, groupCol)) {

                    if (groupValues.contains(cell.getValue())) {
                    return false;
                    }
                    if (cell.getValue() != 0) {
                        groupValues.add(cell.getValue());
                    }
                }
            }
        }

        return true;
    }

    public SudokuCell getCell(int i, int j) {
        
        return board[i][j];
    }

    @Override
    public String toString() {
        String result = "";
        String betweenRows = "+---+---+---+---+---+---+---+---+---+";

        result += betweenRows + "\n";

        for (int row=0 ; row<board.length ; row++) {

            String rowString = "";
            for (int col=0 ; col<board[row].length ; col++) {

                if (board[row][col].getValue() != 0) {
                    rowString += String.format("| %1d ", board[row][col].getValue());
                } else {
                    rowString += "|   ";
                }
            }

            result += rowString + "|\n" + betweenRows + "\n";
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        
        SudokuGame game = new SudokuGame();
        System.out.println(game.getBoard());

        SudokuGenerator.solveBoard(game.getBoard());
        System.out.println(game.getBoard());

        game.setBoard(SudokuGenerator.generateUnsolvedBoard(45));
        System.out.println(game.getBoard());
    }
}
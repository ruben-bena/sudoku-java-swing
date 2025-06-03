package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen extends JFrame {

    private JPanel mainPanel, sudokuPanel; 

    public MainScreen() {

        super();
        setTitle("Sudoku");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // mainPanel
        mainPanel = new JPanel();
        add(mainPanel);

        // sudokuPanel
        sudokuPanel = new SudokuPanel();
        add(sudokuPanel);

        pack();
        setVisible(true);

    }
}

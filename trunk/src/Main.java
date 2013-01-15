import sudoku.SudokuSolver;
import sudoku.SudokuState;

public class Main {

	public static void main(String[] args) {
		
		SudokuState initialState = new SudokuState();
		SudokuSolver  sudokuSolver = new SudokuSolver(initialState);
		SudokuState finalState = sudokuSolver.solve();
		
	}
	
}

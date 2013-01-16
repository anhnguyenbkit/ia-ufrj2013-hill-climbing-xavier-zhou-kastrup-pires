import java.util.Scanner;

import sudoku.SudokuSolver;
import sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Digite o caminho de entrada: ");
		
		Scanner scanner = new Scanner(System.in);
		Sudoku sudoku = new Sudoku(scanner.nextLine());
		SudokuSolver solver = new SudokuSolver(sudoku);
		Sudoku finalSudoku = solver.solve();
		
	}
	
}

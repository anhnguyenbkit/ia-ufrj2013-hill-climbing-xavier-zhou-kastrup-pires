import java.util.Scanner;

import sudoku.Sudoku;
import sudoku.SudokuSolver;

public class Main {

	public static void main(String[] args) {
		
		try {
			System.out.println("Digite o caminho de entrada: ");
			Scanner scanner = new Scanner(System.in);
			Sudoku sudoku = Sudoku.readSudoku(scanner.nextLine());
			SudokuSolver solver = new SudokuSolver(sudoku);
			Sudoku finalSudoku = solver.solve();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}

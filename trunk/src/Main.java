import java.io.IOException;
import java.util.Scanner;

import sudoku.SudokuSolver;
import sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Digite o caminho de entrada: ");
		
		Scanner scanner = new Scanner(System.in);
		try {
			Sudoku sudoku = Sudoku.readSudoku(scanner.nextLine());
			SudokuSolver solver = new SudokuSolver(sudoku);
			Sudoku finalSudoku = solver.solve();
		} catch (IOException ioe) {
			System.out.println("Erro ao ler o arquivo.");
		}
	}
	
}

import java.util.Scanner;

import sudoku.SudokuSolver;
import sudoku.SudokuState;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Digite o caminho de entrada: ");
		
		Scanner scanner = new Scanner(System.in);
		SudokuState state = new SudokuState(scanner.nextLine());
		SudokuSolver finalState = new SudokuSolver(state);
		
	}
	
}

import java.io.IOException;
import java.util.Scanner;

import sudoku.Sudoku;
import sudoku.SudokuSolver;
import test.SudokuTest;

public class Main {

	public static void main(String[] args) {
		
		SudokuTest sudokuTest = new SudokuTest();
		while (true) {
			try {
				sudokuTest.sudokuTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

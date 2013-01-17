package test;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import sudoku.Sudoku;
import sudoku.SudokuSolver;

public class SudokuTest {

	ClassLoader classLoader = SudokuTest.class.getClassLoader();

	@Test
	public void sudokuTest() throws IOException {
		
		String fileIn = classLoader.getResource("test/Hard_input.txt").getFile();
		Sudoku sudokuIn = Sudoku.readSudoku(fileIn);

		String fileOut = classLoader.getResource("test/Hard_output.txt").getFile();
		Sudoku sudokuOut = Sudoku.readSudoku(fileOut);
		
		SudokuSolver solver = new SudokuSolver(sudokuIn);
		Sudoku sudokuSolution = solver.solve();
		
		Assert.assertEquals(sudokuOut, sudokuSolution);
	}
	
	@Test
	public void heuristicsTest() throws IOException {
		
		String solutionFile = classLoader.getResource("test/Hard_output.txt").getFile();
		Sudoku sudokuSolution = Sudoku.readSudoku(solutionFile);
		
		int foundConflicts = SudokuSolver.heuristic(sudokuSolution);
		
		Assert.assertEquals(0, foundConflicts);
	}
	
	@Test
	public void heuristicsContradictionTest() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Caminho do arquivo para testar a heur�stica: ");
		Sudoku solutionWrongExample = Sudoku.readSudoku(scanner.nextLine());
		
		SudokuSolver solver = new SudokuSolver(solutionWrongExample);
		int foundConflicts = solver.heuristic(solutionWrongExample);
		
		Assert.assertEquals(foundConflicts, 6);
		
	}
}

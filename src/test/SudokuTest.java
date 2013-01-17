package test;

import java.io.IOException;

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
		
		String solutionFile1 = classLoader.getResource("test/Beginners_output.txt").getFile();
		Sudoku sudokuSolution1 = Sudoku.readSudoku(solutionFile1);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution1));
		
		String solutionFile2 = classLoader.getResource("test/Easy_output.txt").getFile();
		Sudoku sudokuSolution2 = Sudoku.readSudoku(solutionFile2);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution2));
		
		String solutionFile3 = classLoader.getResource("test/Hard_output.txt").getFile();
		Sudoku sudokuSolution3 = Sudoku.readSudoku(solutionFile3);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution3));
		
		String solutionFile4 = classLoader.getResource("test/Normal_output.txt").getFile();
		Sudoku sudokuSolution4 = Sudoku.readSudoku(solutionFile4);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution4));
		
		String solutionFile5 = classLoader.getResource("test/SuperHard_output.txt").getFile();
		Sudoku sudokuSolution5 = Sudoku.readSudoku(solutionFile5);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution5));
		
		String solutionFile6 = classLoader.getResource("test/test_output.txt").getFile();
		Sudoku sudokuSolution6 = Sudoku.readSudoku(solutionFile6);
		Assert.assertEquals(0, SudokuSolver.heuristic(sudokuSolution6));

	}
	
	@Test
	public void heuristicsContradictionTest() throws IOException {
		
		String solutionFile1 = classLoader.getResource("test/Easy_output_2Conflict.txt").getFile();
		Sudoku sudokuSolution1 = Sudoku.readSudoku(solutionFile1);
		Assert.assertEquals(2, SudokuSolver.heuristic(sudokuSolution1));
		
		String solutionFile2 = classLoader.getResource("test/SuperHard_output_6Conflicts.txt").getFile();
		Sudoku sudokuSolution2 = Sudoku.readSudoku(solutionFile2);
		Assert.assertEquals(6, SudokuSolver.heuristic(sudokuSolution2));
		
	}
}

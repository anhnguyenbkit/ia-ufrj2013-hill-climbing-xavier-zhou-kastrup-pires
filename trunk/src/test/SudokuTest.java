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
		System.out.println("TESTE DO 4 x 4 EASY =================================================================================");
		testExample("test/Easy4x4_input.txt", "test/Easy4x4_output.txt");
		
		System.out.println("TESTE DO 4 x 4 SIMPLE =================================================================================");
		testExample("test/Simple4x4_input.txt", "test/Simple4x4_output.txt");

		System.out.println("TESTE DO 4 x 4 AVERAGE =================================================================================");
		testExample("test/Average4x4_input.txt", "test/Average4x4_output.txt");
		
		System.out.println("TESTE DO 4 x 4 MEDIUM =================================================================================");
		testExample("test/Medium4x4_input.txt", "test/Medium4x4_output.txt");
		
		System.out.println("TESTE DO 4 x 4 HARD =================================================================================");
		testExample("test/Hard4x4_input.txt", "test/Hard4x4_output.txt");
		
		System.out.println("TESTE DO 9 x 9 BEGINNER ===================================================================================");
		testExample("test/Beginners_input.txt", "test/Beginners_output.txt");
		
		System.out.println("TESTE DO 9 x 9 EASY ===================================================================================");
		testExample("test/Easy_input.txt", "test/Easy_output.txt");
		
		System.out.println("TESTE DO 9 x 9 NORMAL ================================================================================");
		testExample("test/Normal_input.txt", "test/Normal_output.txt");

		System.out.println("TESTE DO 9 x 9 HARD =================================================================================");
		testExample("test/Hard_input.txt", "test/Hard_output.txt");
	}
	
	@Test
	public void sudokuTestSuperHard() throws IOException {
		System.out.println("TESTE DO 9 x 9 SUPERHARD =====================================================================================");
		testExample("test/SuperHard_input.txt", "test/SuperHard_output.txt");
	}
	
	public void testExample(String inputFile, String outputFile) throws IOException{
		
		String fileIn = classLoader.getResource(inputFile).getFile();
		Sudoku sudokuIn = Sudoku.readSudoku(fileIn);

		String fileOut = classLoader.getResource(outputFile).getFile();
		Sudoku sudokuOut = Sudoku.readSudoku(fileOut);
		
		SudokuSolver solver = new SudokuSolver(sudokuIn);
		Sudoku sudokuSolution = solver.solve();
		Assert.assertEquals(sudokuOut, sudokuSolution);
	}
	
	@Test
	public void heuristicForSolutions() throws IOException {
		heuristicTest(0, "test/Beginners_output.txt");
		heuristicTest(0, "test/Easy_output.txt");
		heuristicTest(0, "test/Hard_output.txt");
		heuristicTest(0, "test/Normal_output.txt");
		heuristicTest(0, "test/SuperHard_output.txt");
		heuristicTest(0, "test/test_output.txt");
		heuristicTest(0, "test/Average4x4_output.txt");
		heuristicTest(0, "test/Easy4x4_output.txt");
		heuristicTest(0, "test/Hard4x4_output.txt");
		heuristicTest(0, "test/Medium4x4_output.txt");
		heuristicTest(0, "test/Simple4x4_output.txt");
	}

	@Test
	public void heuristicForNonSolutions() throws IOException {
		heuristicTest(2, "test/Easy_output_2Conflict.txt");
		heuristicTest(6, "test/SuperHard_output_6Conflicts.txt");
	}
	
	private void heuristicTest(int value, String path) throws IOException {
		String solutionFile1 = classLoader.getResource(path).getFile();
		Sudoku sudokuSolution1 = Sudoku.readSudoku(solutionFile1);
		Assert.assertEquals(value, SudokuSolver.heuristic(sudokuSolution1));
	}
}

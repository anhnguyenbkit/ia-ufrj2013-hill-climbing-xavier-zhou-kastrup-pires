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
		System.out.println("TESTE DO HARD =================================================================================");
		testExample("test/Hard_input.txt","test/Hard_output.txt");
		System.out.println("\n Só pra lembrar... este foi o hard");
		
		System.out.println("\n TESTE DO EASY ===================================================================================");
		testExample("test/Easy_input.txt","test/Easy_output.txt");
		System.out.println("\n Só pra lembrar... este foi o easy");
		
		System.out.println("\n TESTE DO NORMAL ================================================================================");
		testExample("test/Normal_input.txt","test/Normal_output.txt");
		System.out.println("\n Só pra lembrar... este foi o normal");
		
		System.out.println("\n TESTE DO SUPERHARD =====================================================================================");
		testExample("test/SuperHard_input.txt","test/SuperHard_output.txt");
		System.out.println("\n Só pra lembrar... este foi o superhard");

//		System.out.println("\n TESTE DO BEGINNER =================================================================================");
//		testExample("test/Beginners_input.txt","test/Beginners_output.txt");
//		System.out.println("\n Só pra lembrar... este foi o beginner");
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

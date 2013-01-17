package test;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import sudoku.Sudoku;
import sudoku.SudokuSolver;

public class SudokuTest {

	@Test
	public void sudokuTest() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Caminho do arquivo de entrada: ");
		Sudoku sudokuIn = Sudoku.readSudoku(scanner.nextLine());
		
		System.out.println("Caminho do arquivo de resposta: ");
		Sudoku sudokuOut = Sudoku.readSudoku(scanner.nextLine());
		
		SudokuSolver solver = new SudokuSolver(sudokuIn);
		Sudoku sudokuSolution = solver.solve();
		
		Assert.assertEquals(sudokuSolution, sudokuOut);
		
	}
	
	@Test
	public void heuristicsTest() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Caminho do arquivo para testar a heurística: ");
		Sudoku solutionExample = Sudoku.readSudoku(scanner.nextLine());
		
		SudokuSolver solver = new SudokuSolver(solutionExample);
		int foundConflicts = solver.heuristic(solutionExample);
		
		Assert.assertEquals(foundConflicts, 0);
		
	}
	
	@Test
	public void heuristicsContradictionTest() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Caminho do arquivo para testar a heurística: ");
		Sudoku solutionWrongExample = Sudoku.readSudoku(scanner.nextLine());
		
		SudokuSolver solver = new SudokuSolver(solutionWrongExample);
		int foundConflicts = solver.heuristic(solutionWrongExample);
		
		Assert.assertEquals(foundConflicts, 6);
		
	}
}

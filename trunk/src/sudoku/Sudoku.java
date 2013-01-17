package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {
	
	public int size;
	public int sizeSquare;
	public int[][] matrix;
	
	public Sudoku(int n) {
		this.size = n;
		this.sizeSquare = n*n;
		this.matrix = new int[size][size];
	}
	
	public static Sudoku readSudoku(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fileReader);
		
		String inputLine = input.readLine();
		String[] split = inputLine.split(" ");
		if (split.length != 1) {
			input.close();
			throw new IllegalStateException("Formato de arquivo inválido.");
		}
		Sudoku sudoku = new Sudoku(Integer.parseInt(split[0]));
		
		for (int i = 0; i < sudoku.sizeSquare; i++) {
			inputLine = input.readLine();
			split = inputLine.split(" ");
			if (split.length != sudoku.sizeSquare) {
				input.close();
				throw new IllegalStateException("Formato de arquivo inválido.");
			}
			for (int j = 0; j < sudoku.sizeSquare; j++)
				sudoku.matrix[i][j] = Integer.parseInt(split[j]);
		}
		
		input.close();
		
		return sudoku;
	}
	
	public Sudoku clone() {
		Sudoku sudokuClone = new Sudoku(this.size);
		
		for (int i = 0; i < this.sizeSquare; i++)
			for (int j = 0; j < this.sizeSquare; j++)
				sudokuClone.matrix[i][j] = this.matrix[i][j];
		
		return sudokuClone;
	}

}
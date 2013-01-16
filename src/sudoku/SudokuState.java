package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hillclimbing.State;

public class SudokuState extends State {
	
	private int size;
	private int[][] matrix;
	
	public SudokuState(int n) {
		this.size = n;
		this.matrix = new int[size][size];
	}
	
	public SudokuState(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader input = new BufferedReader(fileReader);
			
			String inputLine = input.readLine();
			String[] split = inputLine.split(" ");
			if (split.length != 1) {
				input.close();
				throw new IllegalStateException("Formato de arquivo inválido.");
			}
			this.size = Integer.parseInt(split[0]);
			this.matrix = new int[size][size];
			
			while (input.ready()) {
				inputLine = input.readLine();
				split = inputLine.split(" ");
				if (split.length != 3) {
					input.close();
					throw new IllegalStateException("Formato de arquivo inválido.");
				}
				int row = Integer.parseInt(split[0]);
				int col = Integer.parseInt(split[1]);
				int value = Integer.parseInt(split[2]);
				this.matrix[row][col] = value;
			}
			
			input.close();
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo '"+fileName+"'.");
		}
	}

	public int getSize() {
		return size;
	}

	public int[][] getMatrix() {
		return matrix;
	}
	
	@Override
	protected SudokuState clone() {
		SudokuState cloneState = new SudokuState(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cloneState.getMatrix()[i][j] = matrix[i][j];
			}
		}
		return cloneState;
	}

}
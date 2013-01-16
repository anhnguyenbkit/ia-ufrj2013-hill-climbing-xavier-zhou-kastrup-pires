package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {
	
	public int size;
	public int sideSize;
	public int[][] matrix;
	
	public Sudoku(int n) {
		this.size = n;
		this.matrix = new int[size][size];
	}
	
	public Sudoku(String fileName) {
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
			this.sideSize = this.size * this.size;
			this.matrix = new int[sideSize][sideSize];
			
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

}
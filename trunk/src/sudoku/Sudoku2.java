package sudoku;

public class Sudoku2 extends Sudoku {

	public int[][][] availableValuesMatrix;
	
	public Sudoku2(int n) {
		super(n);
		this.availableValuesMatrix = new int[sizeSquare][sizeSquare][sizeSquare];
	}
	
	public void updateAvailableValues() {
		for (int i = 0; i < this.sizeSquare; i++) {
			for (int j = 0; j < this.sizeSquare; j++) {
				if (matrix[i][j] != 0) {
					for (int k = 0; k < this.sizeSquare; k++) {
						
					}					
				}
			}
		}
	}
	
	public Sudoku2 clone() {
		Sudoku2 sudokuClone = new Sudoku2(this.size);
		
		for (int i = 0; i < this.sizeSquare; i++) {
			for (int j = 0; j < this.sizeSquare; j++) {
				sudokuClone.matrix[i][j] = this.matrix[i][j];
				sudokuClone.fixed[i][j] = this.fixed[i][j];				
			}			
		}

		
		for (int i = 0; i < this.sizeSquare; i++)
			for (int j = 0; j < this.sizeSquare; j++)
				for (int k = 0; k < this.sizeSquare; k++)				
					sudokuClone.availableValuesMatrix[i][j][k] = this.availableValuesMatrix[i][j][k];
		
		return sudokuClone;
	}
}

package sudoku;

public class SudokuSolver {
	
	Sudoku initialState;
	
	public SudokuSolver(Sudoku initialState) {
		this.initialState = initialState;
	}

	public int heuristic(Sudoku state) {
		int conflicts = 0;
		
		for (int i = 0; i < state.sideSize; i++) {
			int[] val = new int[state.sideSize];
			for (int j = 0; j < state.sideSize; j++) {
				if (++val[state.matrix[i][j] - 1] > 1)
					conflicts++;
			}
		}

		for (int i = 0; i < state.sideSize; i++) {
			int[] val = new int[state.sideSize];
			for (int j = 0; j < state.sideSize; j++) {
				if (++val[state.matrix[j][i] - 1] > 1)
					conflicts++;
			}
		}
		
		for (int i = 0; i < state.size; i++) {
			for (int j = 0; j < state.size; j++) {
				int[] val = new int[state.sideSize];
				for (int k = state.size*i; k < state.size*(i+1); k++) {
					for (int l = state.size*j; l < state.size*(j+1); j++) {
						if (++val[state.matrix[k][l] - 1] > 1)
							conflicts++;
					}
				}
			}
		}
		
		return conflicts;
	}

	public Sudoku solve() {
		// TODO Auto-generated method stub
		return null;
	}

}

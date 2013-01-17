package sudoku;

import java.util.Random;

public class SudokuSolver2 extends SudokuSolver {

	public SudokuSolver2(Sudoku sudoku) {
		super(sudoku);
	}
	
	public Sudoku getInitialState(Sudoku sudoku) {
		Random random = new Random();
		Sudoku initialState = sudoku.clone();
		
		for (int i = 0; i < initialState.sizeSquare; i++) {
			boolean[] used = new boolean[initialState.sizeSquare];
			for (int j = 0; j < initialState.sizeSquare; j++) {
				if (initialState.matrix[i][j] != 0)
					used[initialState.matrix[i][j] - 1] = true;
			}
			for (int j = 0; j < initialState.sizeSquare; j++) {
				if (initialState.matrix[i][j] == 0) {
					int val = random.nextInt(initialState.sizeSquare);
					while (used[val])
						val = random.nextInt(initialState.sizeSquare);
					used[val] = true;
					initialState.matrix[i][j] = val + 1;
				}
			}
		}
		
		return initialState;
	}
	
	public Sudoku solve() {
		Sudoku sudoku = null;
		int countLoops = 0;

		while (true) {
			if (++countLoops == 1)
				System.out.println("Come�ou a resolver.");
			else
				System.out.println("Reiniciou o estado inicial.");
			
			sudoku = getInitialState(initialSudoku);
			int conflicts = heuristic(sudoku);
			
			while (conflicts != 0) {
				for (int i = 0; i < sudoku.sizeSquare; i++) {
					for (int j = 0; j < sudoku.sizeSquare; j++) {
						int minConflicts = Integer.MAX_VALUE;
						Sudoku bestSudoku = null;
						
						for (int k = 0; k < sudoku.sizeSquare; k++) {
							Sudoku tmpSudoku = sudoku.clone();
							int tmpVal = tmpSudoku.matrix[i][j];
							tmpSudoku.matrix[i][j] = tmpSudoku.matrix[i][k];
							tmpSudoku.matrix[i][k] = tmpVal;
							
							int tmpConflicts = heuristic(tmpSudoku);
							if (tmpConflicts < minConflicts) {
								minConflicts = tmpConflicts;
								bestSudoku = tmpSudoku;
							}
						}
						
						sudoku = bestSudoku;
					}
				}
				
				int actualConflicts = heuristic(sudoku);
				if (actualConflicts < conflicts)
					conflicts = actualConflicts;
				else
					break;
			}
			
			if (conflicts == 0) {
				System.out.println("Resolvido!");
				System.out.println("Precisou rodar o algoritmo " + countLoops + " vezes.");
				break;
			}
		}
		
		return sudoku;
	}

}

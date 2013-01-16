package sudoku;

import hillclimbing.HillClimbingSolver;

public class SudokuSolver extends HillClimbingSolver<SudokuState> {
	
	public SudokuSolver(SudokuState initialState) {
		super(initialState);
	}

	@Override
	public int heuristic(SudokuState state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SudokuState solve() {
		// TODO Auto-generated method stub
		return null;
	}

}

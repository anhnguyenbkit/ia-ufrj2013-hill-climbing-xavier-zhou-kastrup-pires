package sudoku;

import hillclimbing.HillClimbingSolver;
import hillclimbing.State;

public class SudokuSolver extends HillClimbingSolver<SudokuState> {
	
	public SudokuSolver(State initialState) {
		super(initialState);
	}

	@Override
	public Integer heuristic(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getNextState(State state) {
		// TODO Auto-generated method stub
		return null;
	}

}

package hillclimbing;

public abstract class HillClimbingSolver<P extends State> {
	
	State initialState;
	
	public HillClimbingSolver(State initialState) {
		this.initialState = initialState;
	}
	
	public abstract Integer heuristic(State state);
	
	public abstract State getNextState(State state);
	
	public P solve() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

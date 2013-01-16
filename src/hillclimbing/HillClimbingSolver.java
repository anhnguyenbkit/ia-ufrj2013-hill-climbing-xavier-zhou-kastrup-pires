package hillclimbing;


public abstract class HillClimbingSolver<P extends State> {
	
	protected P initialState;
	
	public HillClimbingSolver(P initialState) {
		this.initialState = initialState;
	}
	
	public abstract int heuristic(P state);
	
	public abstract P solve();
	
}

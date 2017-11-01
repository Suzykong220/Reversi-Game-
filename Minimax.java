class Minimax {
	public static int count = 0;
	public static int count_with_pruning = 0;
	private static int max_value(State curr_state) {
		count++;
		int a = Integer.MIN_VALUE;
		if (curr_state.isTerminal()) {
			return curr_state.getScore();
		} else {
			if (curr_state.getSuccessors('1').length == 0) {
				return min_value(curr_state);
			} else {
				for (State subState : curr_state.getSuccessors('1')) {
					a = Math.max(a, min_value(subState));
				}
			}
		}
		return a;
	}

	private static int min_value(State curr_state) {
		count++;
		int b = Integer.MAX_VALUE;
		if (curr_state.isTerminal()) {
			return curr_state.getScore();
		} else {
			if (curr_state.getSuccessors('2').length == 0) {
				return max_value(curr_state);
			} else {
				for (State subState : curr_state.getSuccessors('2')) {
					b = Math.min(b, max_value(subState));
				}
			}
		}
		return b;
	}
	public static int max_value_with_pruning(State curr_state, int alpha, int beta) {
		// TO DO: implement Max-Value of the alpha-beta pruning algorithm
		count_with_pruning++;
		if (curr_state.isTerminal()){
			return (curr_state.getScore());
		}
		else {
			// if current state does not have any move for current player, 
			// then it's the opponent's turn 
			if (curr_state.getSuccessors('1').length == 0){
				return min_value_with_pruning(curr_state, alpha, beta);
			}
			for (State s: curr_state.getSuccessors('1')){
				alpha = Math.max(alpha, min_value_with_pruning(s, alpha, beta));
				if (alpha >= beta){
					return beta;
				}
			}
		}
		return alpha;
	}

	public static int min_value_with_pruning(State curr_state, int alpha, int beta) {
		count_with_pruning++;
		// TO DO: implement Min-Value of the alpha-beta pruning algorithm
		if (curr_state.isTerminal()){
			return (curr_state.getScore());
		}
		else {
			if (curr_state.getSuccessors('2').length == 0){
				return max_value_with_pruning(curr_state, alpha, beta);
			}
			for (State s: curr_state.getSuccessors('2')){
				beta = Math.min(beta, max_value_with_pruning(s, alpha, beta));
				if (alpha >= beta){
					return alpha;
				}
			}
		}
		return beta;
	}

	public static int run(State curr_state, char player) {
		// TO DO: run the Minimax algorithm and return the game theoretic value
		if (player == '1'){
			return Minimax.max_value(curr_state);
		} else {
			return Minimax.min_value(curr_state);
		}
	}

	public static int run_with_pruning(State curr_state, char player) {
		int rValue = 0;
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		if (player == '1') {
			rValue = max_value_with_pruning(curr_state, alpha, beta);
		}
		if (player == '2') {
			rValue = min_value_with_pruning(curr_state, alpha, beta);
		}
		return rValue;
		// TO DO: run the alpha-beta pruning algorithm and return the game theoretic value
	}
}

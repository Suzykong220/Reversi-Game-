import java.util.*;

class State {
	char[] board;

	public State(char[] arr) {
		this.board = Arrays.copyOf(arr, arr.length);
	}

	public int getScore() {

		//return game theoretic value of the board
		int countPlayer1 = 0;
		int countPlayer2 = 0;
		for (int i = 0; i < 16; i++){
			if (board[i] == '1'){
				countPlayer1++;
			}
			else {
				countPlayer2++;
			}
		}
		if (countPlayer1 > countPlayer2){
			return 1;
		}
		else if (countPlayer1 < countPlayer2){
			return -1;
		}
		else {
			return 0;
		}
	}

	public boolean isTerminal() {   	
		//determine if the board is a terminal node or not and return boolean 
		if(this.getSuccessors('1').length == 0 && (this.getSuccessors('2').length == 0)) {
		}
		return (this.getSuccessors('1').length == 0) && (this.getSuccessors('2').length == 0);
	}

	public char[] restore(char[] board){    	
		for (int i = 0; i < this.board.length; i++){
			board[i] = this.board[i];
		}
		return board;
	}

	public State[] getSuccessors(char player) {

		//get all successors and return them in proper order

		//initialize array with enough space
		ArrayList<State> successors = new ArrayList<State>();

		//check every disk is legal to put or not
		for(int i = 0; i < this.board.length; i++) {
			if(this.board[i] == '0') {
				char[] newboard = Arrays.copyOf(this.board, this.board.length);

				//check the 8 directions' situations for every disk
				if((i-5)>=0 && (i-5)!=3 && (i-5)!=7) {
					if(this.board[i-5] != player && this.board[i-5] != '0') {
						if((i-5*2)>=0 && (i-5*2)!=3 && (i-5*2)!=7) {

							if(this.board[i-5*2] == player) {
								newboard[i] = player;
								newboard[i-5] = player;
							}

							else if(this.board[i-5*2] != '0') {
								if((i-5*3)>=0 && this.board[i-5*3] == player) {
									newboard[i] = player;
									newboard[i-5] = player;
									newboard[i-5*2] = player;
								}
							}
						}
					}
				}

				if((i-4)>=0) {
					if(this.board[i-4] != player && this.board[i-4] != '0') {
						if((i-4*2)>=0) {

							if(this.board[i-4*2] == player) {
								newboard[i] = player;
								newboard[i-4] = player;
							}

							else if(this.board[i-4*2] != '0') {
								if((i-4*3)>=0 && this.board[i-4*3] == player) {
									newboard[i] = player;
									newboard[i-4] = player;
									newboard[i-4*2] = player;
								}
							}
						}
					}
				}

				if((i-4)>=0 && (i-3)!=4 && (i-3)!=8 && (i-3)!=12) {
					if(this.board[i-3] != player && this.board[i-3] != '0') {
						if((i-3*2)>=0 && (i-3*2)!=0 && (i-3*2)!=4 && (i-3*2)!=8) {

							if(this.board[i-3*2] == player) {
								newboard[i] = player;
								newboard[i-3] = player;
							}

							else if(this.board[i-3*2] != '0') {
								if((i-3*3)>0 && (i-3*3)!=4 && this.board[i-3*3] == player) {
									newboard[i] = player;
									newboard[i-3] = player;
									newboard[i-3*2] = player;
								}
							}
						}
					}
				}

				if((i-1)>=0 && (i-1)!=3 && (i-1)!=7 && (i-1)!=11) {
					if(this.board[i-1] != player && this.board[i-1] != '0') {
						if((i-1*2)>=0 && (i-1*2)!=3 && (i-1*2)!=7 && (i-1*2)!=11) {

							if(this.board[i-1*2] == player) {
								newboard[i] = player;
								newboard[i-1] = player;
							}

							else if(this.board[i-1*2] != '0') {
								if((i-1*3)>=0 && (i-1*3)!=3 && (i-1*3)!=7 && (i-1*3)!=11 && this.board[i-1*3] == player) {
									newboard[i] = player;
									newboard[i-1] = player;
									newboard[i-1*2] = player;
								}
							}
						}
					}
				}

				if((i+1)<=15 && (i+1)!=4 && (i+1)!=8 && (i+1)!=12) {
					if(this.board[i+1] != player && this.board[i+1] != '0') {
						if((i+1*2)<=15 && (i+1*2)!=4 && (i+1*2)!=8 && (i+1*2)!=12) {

							if(this.board[i+1*2] == player) {
								newboard[i] = player;
								newboard[i+1] = player;
							}

							else if(this.board[i+1*2] != '0') {
								if((i+1*3)<=15 && (i+1*3)!=4 && (i+1*3)!=8 && (i+1*3)!=12 && this.board[i+1*3] == player) {
									newboard[i] = player;
									newboard[i+1] = player;
									newboard[i+1*2] = player;
								}
							}
						}
					}
				}

				if((i+3)<15 && (i+3)!=3 && (i+3)!=7 && (i+3)!=11) {
					if(this.board[i+3] != player && this.board[i+3] != '0') {
						if((i+3*2)<15 && (i+3*2)!=7 && (i+3*2)!=11) {

							if(this.board[i+3*2] == player) {
								newboard[i] = player;
								newboard[i+3] = player;
							}

							else if(this.board[i+3*2] != '0') {
								if((i+3*3)<15 && (i+3*3)!=11 && this.board[i+3*3] == player) {
									newboard[i] = player;
									newboard[i+3] = player;
									newboard[i+3*2] = player;
								}
							}
						}
					}
				}

				if((i+4)<=15) {
					if(this.board[i+4] != player && this.board[i+4] != '0') {
						if((i+4*2)<=15) {

							if(this.board[i+4*2] == player) {
								newboard[i] = player;
								newboard[i+4] = player;
							}

							else if(this.board[i+4*2] != '0') {
								if((i+4*3)<=15 && this.board[i+4*3] == player) {
									newboard[i] = player;
									newboard[i+4] = player;
									newboard[i+4*2] = player;
								}
							}
						}
					}
				}

				if((i+5)<=15 && (i+5)!=8 && (i+5)!=12) {
					if(this.board[i+5] != player && this.board[i+5] != '0') {
						if((i+5*2)<=15 && (i+5*2)!=12) {

							if(this.board[i+5*2] == player) {
								newboard[i] = player;
								newboard[i+5] = player;
							}

							else if(this.board[i+5*2] != '0') {
								if((i+5*3)<=15 && this.board[i+5*3] == player) {
									newboard[i] = player;
									newboard[i+5] = player;
									newboard[i+5*2] = player;
								}
							}
						}
					}
				}

				//if the disk is legal, add a new successor
				State newstate = new State(newboard);
				if(!newstate.equals(this)) {
					successors.add(newstate);
				}

			}
		}
		State[] successors_result = new State[successors.size()];
		successors_result = successors.toArray(successors_result);
		return successors_result;
	}

	public void printState(int option, char player) {

		//print a State based on option (flag)
		if(option == 1){
			for (int i = 0; i < this.getSuccessors(player).length; i++){
				System.out.println(this.getSuccessors(player)[i].getBoard());
			}    	   
		}
		else if (option == 2){
			if (!this.isTerminal()){
				System.out.println("non-terminal");
			}
			else {
				System.out.println(this.getScore());
			}
		}
		else if (option == 3){  
			State init = new State(board);	
			Minimax.run(init, player);
			System.out.println(this.getScore());
			System.out.println(Minimax.count);
		}
		else if (option == 4){
			int temp = Integer.MIN_VALUE;
			int optimalValue = Integer.MIN_VALUE;

			if (!isTerminal()){
				State curr = new State(board);

				optimalValue = Minimax.run(curr, player);
				System.out.println(optimalValue);
				State optimal = new State(board); 
				for (State s : getSuccessors(player)){				
					temp = Minimax.run(s, player);
					if (temp  == optimalValue){
						optimal = s;
						break;
					}
				}
				System.out.println(optimal.getBoard());
			}
		}	
		else if (option == 5){
			State init = new State(board);			
			System.out.println(Minimax.run_with_pruning(init, player));
			System.out.println(Minimax.count_with_pruning);
		}
		else if (option == 6){
			int temp = Integer.MIN_VALUE;
			int gtv_score = Integer.MIN_VALUE;
			State curr = new State(board);
			gtv_score = Minimax.run_with_pruning(curr, player);
			if (!isTerminal()){
				if(getSuccessors(player).length != 0){
					State optimal = new State(board); 
					for (State s : getSuccessors(player)){				
						temp = Minimax.run_with_pruning(s, player);
						if (temp == gtv_score){
							optimal = s;
							System.out.println(optimal.getBoard());
							break;
						}
					}
				}
				else {
					return;
				}
			}
		}				
	}

	public String getBoard() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			builder.append(this.board[i]);
		}
		return builder.toString().trim();
	}

	public boolean equals(State src) {
		for (int i = 0; i < 16; i++) {
			if (this.board[i] != src.board[i])
				return false;
		}
		return true;
	}
}


public class Reversi {
	public static void main(String args[]) {
		if (args.length != 3) {
			System.out.println("Invalid Number of Input Arguments");
			return;
		}
		int flag = Integer.valueOf(args[0]);
		char[] board = new char[16];
		for (int i = 0; i < 16; i++) {
			board[i] = args[2].charAt(i);
		}
		int option = flag / 100;
		char player = args[1].charAt(0);
		if ((player != '1' && player != '2') || args[1].length() != 1) {
			System.out.println("Invalid Player Input");
			return;
		}
		State init = new State(board);
		init.printState(option, player);
	}
}

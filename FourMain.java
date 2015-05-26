import java.util.*;

public class FourMain {
	
	static int turn = 1;
	static Cell[][] cells = new Cell[6][7]; 
	static Player p1, p2;
	static Scanner scn = new Scanner(System.in);
	static int round = 1;
	
	public static void main(String[] args) {		
		initializeBoard();
		p1 = new Player("P1", 'a');
		p2 = new Player("P2", 'b');
	
		while(!checkMatchedFour()) {
			displayBoard();
			System.out.println("Round : " + round);
			displayTurnMessage();	
			switchTurn();
			round++;
			System.out.println("========= End of Round " + round + " ==========");
		}
		
		if(turn == 1) System.out.println("[SYSTEM MESSAGE] P2 wins");
		else 		  System.out.println("[SYSTEM MESSAGE] P1 wins");
		displayBoard();
	}
	
	public static void superHACK() {
		for(int i=3; i<cells.length; i++) {
			for(int j=0; j<cells[i].length; j++) {
				if(i == j) {
					cells[i][j].setSymbol('a');
				}
			}
		}
	}
	
	public static void displayBoard() {
		String output = "1 2 3 4 5 6 7\n";
		for(int i=0; i<cells.length; i++) {
			for(int j=0; j<cells[i].length; j++) {
				output += cells[i][j].getSymbol() + " ";
			}
			output += "\n";
		}
		System.out.println(output);
	}
	
	public static void displayTurnMessage() {
		if(turn == 1) { 
			System.out.println("Enter a col # (P1) : ");
			if(!insertToBoard(scn.nextInt(),1)) {
				displayTurnMessage();
			}
		}
		else {
			System.out.println("Enter a col # (P2) : ");
			if(!insertToBoard(scn.nextInt(),2)) {
				displayTurnMessage();
			}
		}
 		
	}
	
	public static boolean insertToBoard(int col, int player) {
		char symbol = '#';
		if(player == 1) {
			symbol = p1.getSymbol();
		} else {
			symbol = p2.getSymbol();
		}
		
		if(col > 6 || col < 0) {
			System.out.println("Invalid Column Number. Valid Range (1 to 7)");
			return false;
		}
		
		if(cells[cells.length-1][col-1].getSymbol() == '#') {
			cells[cells.length-1][col-1].setSymbol(symbol);
			return true;
		}
	
		for(int i=0; i<6; i++) {
			if(cells[i][col-1].getSymbol() != '#') {
				if((i-1) < 0) {
					System.out.println("Column Full.");
					return false;
				} else {
					cells[i-1][col-1].setSymbol(symbol);	
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	public static void initializeBoard() {
		for(int i=0; i<cells.length; i++) {
			for(int j=0; j<cells[i].length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public static boolean checkReverseDiagonal() {
		for(int row=5; row > -1; row--) {
			for(int col=6; col > -1; col--) {
				if(((row+3) > 5 || (col-3) < 0)) {
					break;
				} else {
					if(checkMatched(cells[row][col].getSymbol(), cells[row+1][col-1].getSymbol(), cells[row+2][col-2].getSymbol(), cells[row+3][col-3].getSymbol())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean checkMatchedFour() {
		if(!checkHorizontal()) {
			if(!checkVertical()) {
				if(!checkDiagonal() && !checkReverseDiagonal()) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
	
	public static boolean checkHorizontal() {
		for(int i=0; i<cells.length; i++) {
			for(int j=0; j<cells[i].length-4; j++) {
				if((j+3) > 6) {
					break;
				} else {
					if(checkMatched(cells[i][j].getSymbol(),cells[i][j+1].getSymbol(),cells[i][j+2].getSymbol(),cells[i][j+3].getSymbol())) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	public static boolean checkMatched(char c1, char c2, char c3, char c4) {
		if(c1 == c2 && c1 == c3 && c1 == c4) {
			if(c1 == '#') return false;
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkVertical() {
		for(int col=0; col<7; col++) {
			for(int row=0; row<6; row++) {
				if((row+3) > 5) {
					break;
				} else {
					if(checkMatched(cells[row][col].getSymbol(), cells[row+1][col].getSymbol(), cells[row+2][col].getSymbol(), cells[row+3][col].getSymbol())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean checkDiagonal() {
		for(int row=0; row<6; row++) {
			for(int col=0; col<7; col++) {
				if(((row+3) > 5 || (col+3) > 6)) {
					break;
				} else {
					if(checkMatched(cells[row][col].getSymbol(), cells[row+1][col+1].getSymbol(), cells[row+2][col+2].getSymbol(), cells[row+3][col+3].getSymbol())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static void switchTurn() {
		if(turn == 1) turn = 2;
		else turn = 1;
	}
}

import java.util.*;

public class FourMain {
	
	static int turn = 0;
	static Cell[][] cells = new Cell[6][7]; 
	
	public static void main(String[] args) {		
		Player p1, p2;
		initializeBoard();
		p1 = new Player("P1", "a");
		p2 = new Player("P2", "b");
		
		while(!checkMatchedFour()) {
			displayTurnMessage();
			
		}
	}
	
	public static void displayTurnMessage() {
		
	}
	
	public static void initializeBoard() {
		for(int i=0; i<cells.length; i++) {
			for(int j=0; j<cells[i].length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public static boolean checkMatchedFour() {
		if(!checkHorizontal()) {
			if(!checkVertical()) {
				if(!checkDiagonal()) {
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
		return false;
	}
	
	public static boolean checkVertical() {
		return false;
	}
	
	public static boolean checkDiagonal() {
		return false;
	}
	
	public static void switchTurn() {
		if(turn == 0) turn = 1;
		else turn = 0;
	}
}

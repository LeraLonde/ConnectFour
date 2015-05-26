
public class Cell {
	private boolean occupied;
	private char symbol;
	
	public Cell() {
		//Default Settings
		this.occupied = false;
		this.symbol = '#';
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}

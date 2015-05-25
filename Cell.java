
public class Cell {
	private boolean occupied;
	private String symbol;
	
	public Cell() {
		//Default Settings
		this.occupied = false;
		this.symbol = "#";
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}

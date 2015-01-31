package shop;

public class Symbol {
	private Player whoSet;
	private String symbol;
	private int coordinate;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(int coordinate) {
		this.coordinate = coordinate;
	}
	public Player getWhoSet() {
		return whoSet;
	}
	public void setWhoSet(Player whoSet) {
		this.whoSet = whoSet;
	}
	

}

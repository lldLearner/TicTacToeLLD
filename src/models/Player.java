package models;

public class Player {

	private String name;
	private char symbol;
	private int retryCount;
	private boolean isRetryExceeded;
	
	public Player(String name, char symbol) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.symbol = symbol;
		this.retryCount = 0;
		this.isRetryExceeded = false;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}
	
	public int getRetryCount() {
		return this.retryCount;
	}
	
	public void incrementRetryCount() {
		// TODO Auto-generated method stub
		this.retryCount++;
	}
	
	public void resetRetryCount() {
		this.retryCount = 0;
	}
	
	public void setIsRetryExceeded(boolean isRetryExceeded) {
		// TODO Auto-generated method stub
		this.isRetryExceeded = isRetryExceeded;
	}
	
	public boolean getIsRetryExceeded() {
		return this.isRetryExceeded;
	}
}

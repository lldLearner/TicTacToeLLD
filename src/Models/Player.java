package Models;

public class Player extends Observer {

	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}


	@Override
	void update(char[][] board) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " : the current board looks like " );
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			
			System.out.println();
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getSymbol() {
		return symbol;
	}


	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}

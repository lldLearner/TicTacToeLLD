package models;

public class Board {

	private int n;
	private char[][] board;
	
	public Board(int n) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.board = new char[n][n];
	}

	public int getSize() {
		return n;
	}

	public char[][] getBoard() {
		return board;
	}
	
	public void displayBoard() {
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}
}

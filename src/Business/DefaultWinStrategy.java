package Business;

public class DefaultWinStrategy implements WinStrategy {

	@Override
	public boolean isWinner(char symbol, char[][] board) {
		// TODO Auto-generated method stub
		for(int i = 0; i < board.length; i++) {
			if(rowCheck(i, board, symbol) || colCheck(i, board, symbol)) {
				return true;
			}
		}
		
		return diagonalCheck(board, symbol) || antiDiagonalCheck(board, symbol);
	}
	
	public boolean rowCheck(int r, char[][] board, char symbol) {
		for(int col = 0; col < board.length; col++) {
			if(board[r][col] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean colCheck(int c, char[][] board, char symbol) {
		for(int row = 0; row < board.length; row++) {
			if(board[row][c] != symbol) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean diagonalCheck(char[][] board, char symbol) {
		
		for(int i = 0; i < board.length; i++) {
			if(board[i][i] != symbol) {
				return false;
			}
		}
		return true;
	}
	
	public boolean antiDiagonalCheck(char[][] board, char symbol) {
		for(int i = 0; i < board.length; i++) {
			if(board[i][board.length - i - 1] != symbol) {
				return false;
			}
		}
		
		return true;
	}

}

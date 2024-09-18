package Services;

public class WinService {

	public static boolean isWinner(int row, int col, char symbol, char[][] board) {

		return isRowWinner(row, board, symbol) || isColWinner(col, board, symbol) || isDiagonalWinner(board, symbol)
				|| isAntiDiagonalWinner(board, symbol);
	}

	private static boolean isRowWinner(int row, char[][] board, char symbol) {

		for (int c = 0; c < board.length; c++) {
			if (board[row][c] != symbol) {
				return false;
			}
		}

		return true;
	}

	private static boolean isColWinner(int col, char[][] board, char symbol) {

		for (int r = 0; r < board.length; r++) {
			if (board[r][col] != symbol) {
				return false;
			}
		}

		return true;
	}

	private static boolean isDiagonalWinner(char[][] board, char symbol) {
		for (int r = 0; r < board.length; r++) {
			if (board[r][r] != symbol) {
				return false;
			}
		}

		return true;
	}

	private static boolean isAntiDiagonalWinner(char[][] board, char symbol) {
		for (int r = 0; r < board.length; r++) {
			if (board[r][board.length - r - 1] != symbol) {
				return false;
			}
		}

		return true;
	}
}

package Services;

import models.Player;

public class MoveValidatorService {

	public static boolean validateMove(int row, int col, char symbol, Player currentPLayer, int n, char[][] board) {
		// TODO Auto-generated method stub
		
		return (currentPLayer.getSymbol() == symbol) && 
				(row >= 0 && col >= 0 && row < n && col < n)
				&& board[row][col] == '\0';
	}
}

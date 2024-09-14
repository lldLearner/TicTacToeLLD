package Business;

import Models.Board;

public class MoveService {

	public static void isMoveValid(int r, int c, Board board, char symbol) {

		if (r < 0 || c < 0 || r > 2 || c > 2 || board.getBoard()[r][c] != '\0') {
			throw new RuntimeException("Please choose the valid cell, either the cell is filled or invalid!");
		}

		board.updateCell(r, c, symbol);
	}
}

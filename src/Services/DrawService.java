package Services;

public class DrawService {
	
	public static boolean isGameDraw(char[][] board) {
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board.length; c++) {
				if(board[r][c] == '\0') {
					return false;
				}
			}
		}
		
		return true;
	}

}

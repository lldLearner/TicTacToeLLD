import java.util.Arrays;
import java.util.Scanner;

import Business.DefaultWinStrategy;
import Business.MoveService;
import Business.WinStrategy;
import Models.Board;
import Models.Player;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialise the tic tac toe board
		Board board = new Board(3);

		//initialise players and assign symbols
		Player p1 = new Player("kartik", 'X');
		Player p2 = new Player("Kv", 'O');

		//add players to the game
		board.addPlayer(p1);
		board.addPlayer(p2);

		Scanner sc = new Scanner(System.in);
		
		//set the win strategy of the game
		WinStrategy winStrategy = new DefaultWinStrategy();
		while (true) {
			
			// prompt current player to pick a cell and make a move
			Player currentPlayer = board.getCurrentPlayer();
			System.out.println(currentPlayer.getName() + " : choose row 0, 1, or 2 and col 0, 1, or 2");
			int row = sc.nextInt();
			int col = sc.nextInt();
			try {
				//move is valid then update the board, or try again
				MoveService.isMoveValid(row, col, board, currentPlayer.getSymbol());
				
				//check if after move, current player wins the game, then declare winner and break
				if (winStrategy.isWinner(currentPlayer.getSymbol(), board.getBoard())) {
					System.out.println(currentPlayer.getName() + " wins the game");
					break;
				}

				//check if after move, current game is draw, then declare draw and break
				if (Client.isDraw(board.getBoard())) {
					System.out.println("the game is draw!");
					break;
				}

				//none of the above, so go to next player
				board.nextTurn();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean isDraw(char[][] board) {
		// TODO Auto-generated method stub
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				if (board[r][c] == '\0') {
					return false;
				}
			}
		}

		return true;
	}

}

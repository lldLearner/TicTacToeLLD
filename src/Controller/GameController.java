package Controller;

import java.util.Scanner;

import Services.DrawService;
import Services.MoveValidatorService;
import Services.WinService;
import models.Game;
import models.Player;

public class GameController {

	private Game game;
	private Scanner sc;

	public GameController(Game game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.sc = new Scanner(System.in);
	}

	public void startGame() {
		while (true) {
			game.getBoard().displayBoard();
			Player currPlayer = game.getCurrentPlayer();
			System.out.println(currPlayer.getName() + " -> ");
			System.out.println("make your move by chosing cell!");
			int row = sc.nextInt();
			int col = sc.nextInt();
			System.out.println("place a symbol in that cell");
			char symbol = sc.next().charAt(0);

			if (!makeMove(currPlayer, row, col, symbol)) {
				if(!currPlayer.getIsRetryExceeded()) {
					System.out.println("Wrong move, try again!");
					continue;
				}
			} else if (WinService.isWinner(row, col, symbol, game.getBoard().getBoard())) {
				game.getBoard().displayBoard();
				System.out.println(currPlayer.getName() + " wins the game!");
				break;
			} else if (DrawService.isGameDraw(game.getBoard().getBoard())) {
				game.getBoard().displayBoard();
				System.out.println("game is draw");
				break;
			}

			currPlayer.setIsRetryExceeded(false);
			currPlayer.resetRetryCount();
			System.out.println(currPlayer.getName() + " " + currPlayer.getRetryCount());

			game.nextTurn();
		}
	}

	public boolean makeMove(Player currPlayer, int row, int col, char symbol) {

		boolean isMoveValid = MoveValidatorService.validateMove(row, col, symbol, currPlayer, game.getBoard().getSize(),
				game.getBoard().getBoard());
		if (isMoveValid) {
			game.getBoard().getBoard()[row][col] = symbol;
		} else {
			currPlayer.incrementRetryCount();

			if (currPlayer.getRetryCount() > game.getMaxRetryCount()) {
				currPlayer.setIsRetryExceeded(true);
				System.out.println("retry count limit exceeded!");
				return false;
			}
		}

		return isMoveValid;
	}
}

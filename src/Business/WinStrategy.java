package Business;

import Models.Player;

public interface WinStrategy {

	boolean isWinner(char symbol, char[][] board);
}

package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private char[][] board;
	private int size;
	private List<Player> players;
	private int currentPlayerIndex = 0;
	
	public Board(int size) {
		this.size = size;
		this.board = new char[this.size][this.size];
		this.players = new ArrayList<>();
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void notifyPlayers() {
		for(Player player : players) {
			player.update(board);
		}
	}

	public char[][] getBoard() {
		return board;
	}

	public int getSize() {
		return size;
	}
	
	public void nextTurn() {
		currentPlayerIndex = (currentPlayerIndex + 1) %  players.size();
	}
	
	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}
	
	public void updateCell(int r, int c, char symbol) {
		board[r][c] = symbol;
		notifyPlayers();
	}
}

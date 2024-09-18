package models;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private Board board;
	private List<Player> players;
	private int currentPlayerIndex;
	private final int MAX_RETRY_COUNT;
	
	public Game(Board b) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.players = new ArrayList<>();
		this.currentPlayerIndex = 0;
		this.MAX_RETRY_COUNT = 3;
	}
	
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void nextTurn() {
		this.currentPlayerIndex = (currentPlayerIndex + 1) % this.players.size();
	}	
	
	public Player getCurrentPlayer() {
		return this.players.get(currentPlayerIndex);
	}
	
	public int getMaxRetryCount() {
		return this.MAX_RETRY_COUNT;
	}
	
	public Board getBoard() {
		return board;
	}
}

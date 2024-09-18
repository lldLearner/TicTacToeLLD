import Controller.GameController;
import models.Board;
import models.Game;
import models.Player;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		Board board = new Board(n);

		Game g1 = new Game(board);
		Player p1 = new Player("kartik", 'X');
		Player p2 = new Player("sweta", 'O');

		g1.addPlayer(p1);
		g1.addPlayer(p2);

		GameController gameController = new GameController(g1);
		gameController.startGame();
	}

}

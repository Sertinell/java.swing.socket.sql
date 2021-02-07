package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.SessionController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.FullView;
import usantatecla.tictactoe.views.PlayView;
import usantatecla.tictactoe.views.ResumeView;
import usantatecla.tictactoe.views.StartView;

class TicTacToe {

	private SessionController sessionController;

	private Game game;

	TicTacToe() {
		this.game = new Game();
		FullView view = new FullView();
		this.sessionController = new SessionController(game, view, view, view);
	}
	
	public static void main(String[] args) {
		new TicTacToe().play();
	}

	private void play() {
		sessionController.run();
	}
}
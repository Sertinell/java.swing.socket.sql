package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

class TicTacToe {

	private View view;

	private Game game;
	private StartController 	startController;
	private ResumeController 	resumeController;
	private PlayController	 	playController;

	TicTacToe() {
		this.game = new Game();
		createControllers();
		this.view = new View(startController, playController, resumeController);
	}

	private void createControllers(){
		this.startController = new StartController(game);
		this.playController = new PlayController(game);
		this.resumeController = new ResumeController(game);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
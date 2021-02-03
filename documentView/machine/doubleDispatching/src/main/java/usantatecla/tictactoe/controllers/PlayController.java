package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;

import usantatecla.tictactoe.views.interfaces.IPlayView;
import usantatecla.tictactoe.views.interfaces.IPlayerView;

public class PlayController extends GameController{

	public PlayController(Game game) {
        super(game);
	}

	public void next() {
        this.game.next();
	}

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}

	public Color getActiveColor() {
		return this.game.getActiveColor();
	}

	public void run(IPlayView view) {
		do {
			IPlayerView playerView = view.getCurrentPlayerView(this.game);
			new PlayerController(this.game.getActivePlayer()).run(playerView);
			this.next();
			view.onBoardUpdate(this.game);
		} while (!this.game.isTicTacToe());
		view.onPlayerWin(this.game.getActiveColor());
	}
}

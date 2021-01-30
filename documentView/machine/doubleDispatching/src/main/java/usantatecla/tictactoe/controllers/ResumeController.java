package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class ResumeController extends GameController{

	public ResumeController(Game game) {
        super(game);
	}

	public void reset() {
        this.game.reset();
	}
}

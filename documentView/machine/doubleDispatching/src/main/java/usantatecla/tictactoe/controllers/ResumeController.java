package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.interfaces.IResumeView;

public class ResumeController extends GameController{

	public ResumeController(Game game) {
        super(game);
	}

	public void reset() {
        this.game.reset();
	}

	public boolean run(IResumeView view) {
		boolean resume = view.getResume();
		this.game.reset();
		return resume;
	}
}

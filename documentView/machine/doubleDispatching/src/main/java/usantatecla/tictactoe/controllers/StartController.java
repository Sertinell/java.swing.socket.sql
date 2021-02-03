package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.interfaces.IStartView;

public class StartController extends GameController{

	public StartController(Game game) {
        super(game);
	}

	public void run(IStartView view) {
		view.onStartGame(game);
		game.setUsers(view.getNumUsers(game.getNumPlayers()));
		view.onBoardUpdate(game);
	}
    
}

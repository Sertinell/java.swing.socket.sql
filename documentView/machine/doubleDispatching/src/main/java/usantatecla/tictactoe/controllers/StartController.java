package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class StartController extends GameController{

	public StartController(Game game) {
        super(game);
	}

	public void setUsers(int nUsers) {
        game.setUsers(nUsers);
	}

	public int getNumPlayers() {
		return game.getNumPlayers();
	}
    
}

package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;

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

	public PlayerController getCurrentPlayerController() {
        if(this.game.getActivePlayerId() >= game.getUsers()){
            return new MachinePlayerController(this.game.getActivePlayer());
        }
        else {
            return new UserPlayerController(this.game.getActivePlayer());
        }
	}
}

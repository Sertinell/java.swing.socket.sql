package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.PlayerControllerVisitor;

public abstract class PlayerController {
    Player player;

    public abstract void accept(PlayerControllerVisitor playerVisitor);

    protected PlayerController(Player player) {
        this.player = player;
    }

	public boolean areAllTokensOnBoard() {
		return this.player.areAllTokensOnBoard();
	}

	public void putToken(Coordinate coordinate) {
        this.player.putToken(coordinate);
	}

	public Error getPutTokenError(Coordinate coordinate) {
		return this.player.getPutTokenError(coordinate);
	}

	public void moveToken(Coordinate origin, Coordinate target) {
        this.player.moveToken(origin, target);
	}

	public Error getOriginMoveTokenError(Coordinate origin) {
		return this.player.getOriginMoveTokenError(origin);
	}

	public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
		return this.player.getTargetMoveTokenError(origin, target);
	}
}

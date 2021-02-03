package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.interfaces.IPlayerView;

public class PlayerController {
    Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

	public boolean areAllTokensOnBoard() {
		return this.player.areAllTokensOnBoard();
	}

	private void putToken(IPlayerView view) {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = view.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
			error = this.player.getPutTokenError(coordinate);
			view.onPutTokenError(error);
        } while (!error.isNull());
        this.player.putToken(coordinate);
    }

    private void moveToken(IPlayerView view) {
        Coordinate origin;
        Error error;
        do {
            origin = view.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.player.getOriginMoveTokenError(origin);
			view.onOriginMoveTokenError(error);
        } while (error != Error.NULL);
        Coordinate target;
        do {
            target = view.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.player.getTargetMoveTokenError(origin, target);
			view.onTargetMoveTokenError(error);
        } while (error != Error.NULL);
        this.player.moveToken(origin, target);
    }

	public void run(IPlayerView playerView){
		if (!this.player.areAllTokensOnBoard()) {
            this.putToken(playerView);
        } else {
            this.moveToken(playerView);
        }
	}
}

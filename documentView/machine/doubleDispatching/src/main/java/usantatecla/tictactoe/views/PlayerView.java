package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayerController;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

abstract class PlayerView {

    protected PlayerController playerController;

    protected PlayerView(PlayerController playerController) {
        this.playerController = playerController;
    }

    void interact() {
        if (!this.playerController.areAllTokensOnBoard()) {
            this.putToken();
        } else {
            this.moveToken();
        }
    }

    private void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.playerController.putToken(coordinate);
    }

    protected abstract Coordinate getCoordinate(Message message);

    protected Error getPutTokenError(Coordinate coordinate) {
        return this.playerController.getPutTokenError(coordinate);
    }

    private void moveToken() {
        Coordinate origin;
        Error error;
        do {
            origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
            error = this.getOriginMoveTokenError(origin);
        } while (error != Error.NULL);
        Coordinate target;
        do {
            target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
            error = this.getTargetMoveTokenError(origin, target);
        } while (error != Error.NULL);
        this.playerController.moveToken(origin, target);
    }

    protected Error getOriginMoveTokenError(Coordinate origin) {
        return this.playerController.getOriginMoveTokenError(origin);
    }

    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.playerController.getTargetMoveTokenError(origin, target);
    }    
}

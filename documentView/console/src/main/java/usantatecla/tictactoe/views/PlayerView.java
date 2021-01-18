package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Error;

public abstract class PlayerView {

    protected Player player;

    void interact(Player player) {
        this.player = player;
        if (this.player.getPutTokens() < Coordinate.DIMENSION) {
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
        this.player.putToken(coordinate);
    }

    protected abstract Coordinate getCoordinate(Message message);

    protected Error getPutTokenError(Coordinate coordinate) {
        return this.player.getPutTokenError(coordinate);
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
        this.player.moveToken(origin, target);
    }

    protected Error getOriginMoveTokenError(Coordinate origin) {
        return this.player.getOriginMoveTokenError(origin);
    }

    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.player.getTargetMoveTokenError(origin, target);
    }
}

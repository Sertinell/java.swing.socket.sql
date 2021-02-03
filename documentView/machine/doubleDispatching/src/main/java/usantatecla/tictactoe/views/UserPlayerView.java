package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class UserPlayerView extends PlayerView {

    @Override
    public Coordinate getCoordinate(Message message) {
        assert message != null;
        return (Coordinate) new CoordinateView().read(message.toString());
    }

    @Override
    public void onPutTokenError(Error error) {
        new ErrorView().writeln(error);
    }

    @Override
    public void onOriginMoveTokenError(Error error) {
        new ErrorView().writeln(error);
    }

    @Override
    public void onTargetMoveTokenError(Error error) {
        new ErrorView().writeln(error);
    }
}

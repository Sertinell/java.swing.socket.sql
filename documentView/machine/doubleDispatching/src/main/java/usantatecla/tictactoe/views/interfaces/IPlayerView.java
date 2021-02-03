package usantatecla.tictactoe.views.interfaces;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.types.Error;

public interface IPlayerView {
    public Coordinate getCoordinate(Message message);
    public void onPutTokenError(Error error);
    public void onOriginMoveTokenError(Error error);
    public void onTargetMoveTokenError(Error error);
}

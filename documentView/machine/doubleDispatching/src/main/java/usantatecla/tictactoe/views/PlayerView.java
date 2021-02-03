package usantatecla.tictactoe.views;

import usantatecla.tictactoe.views.interfaces.IPlayerView;
import usantatecla.tictactoe.types.Error;
abstract class PlayerView implements IPlayerView{
    protected PlayerView() {
    }

    public void onPutTokenError(Error error){}

    public void onOriginMoveTokenError(Error error){}

    public void onTargetMoveTokenError(Error error){}
}

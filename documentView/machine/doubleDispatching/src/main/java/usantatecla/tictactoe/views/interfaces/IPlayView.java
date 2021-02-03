package usantatecla.tictactoe.views.interfaces;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;

public interface IPlayView {
    public IPlayerView getCurrentPlayerView(Game game);
    public void onBoardUpdate(Game game);
    public void onPlayerWin(Color color);
}

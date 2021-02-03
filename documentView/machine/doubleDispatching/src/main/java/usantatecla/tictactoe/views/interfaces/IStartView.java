package usantatecla.tictactoe.views.interfaces;

import usantatecla.tictactoe.models.*;

public interface IStartView {
    public void onStartGame(Game game);
    public void onBoardUpdate(Game game);
    public int  getNumUsers(int maxUsers);
}

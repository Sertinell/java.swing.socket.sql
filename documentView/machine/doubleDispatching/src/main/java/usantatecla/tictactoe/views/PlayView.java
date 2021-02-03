package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.interfaces.IPlayView;
import usantatecla.tictactoe.views.interfaces.IPlayerView;

public class PlayView implements IPlayView {
    @Override
    public void onBoardUpdate(Game game) {
        new BoardView().write(game);
    }

    @Override
    public IPlayerView getCurrentPlayerView(Game game) {
        if(game.getActivePlayerId() >= game.getUsers()){
            return new MachinePlayerView();
        } else {
            return new UserPlayerView();
        }
    }

    @Override
    public void onPlayerWin(Color color) {
        Message.PLAYER_WIN.writeln(color.name());
    }
}

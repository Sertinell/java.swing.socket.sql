package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.interfaces.*;
import usantatecla.utils.views.BoundedIntDialog;
import usantatecla.utils.views.YesNoDialog;

public class FullView implements IStartView, IPlayView, IResumeView {

    @Override
	public boolean getResume() {
		YesNoDialog isResumed = new YesNoDialog();
		isResumed.read(Message.RESUME.toString());
		return isResumed.isAffirmative();
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

    @Override
	public void onStartGame(Game game) {
		Message.TITLE.writeln();
	}

	@Override
	public int getNumUsers(int maxUsers) {
		BoundedIntDialog dialog = new BoundedIntDialog(0, maxUsers);
		return dialog.read(Message.NUMBER_PLAYERS.toString());
	}

	@Override
	public void onBoardUpdate(Game game) {
		new BoardView().write(game);
	}
}

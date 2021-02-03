package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.interfaces.IStartView;
import usantatecla.utils.views.BoundedIntDialog;

public class StartView implements IStartView {
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

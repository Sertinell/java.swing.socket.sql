package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.utils.views.BoundedIntDialog;

class StartView {

	StartController startController;

    StartView(StartController startController) {
		this.startController = startController;
	}

    void interact() {
		Message.TITLE.writeln();
		BoundedIntDialog dialog = new BoundedIntDialog(0, this.startController.getNumPlayers());
		this.startController.setUsers(dialog.read(Message.NUMBER_PLAYERS.toString()));
		new BoardView().write(this.startController);
	}

}

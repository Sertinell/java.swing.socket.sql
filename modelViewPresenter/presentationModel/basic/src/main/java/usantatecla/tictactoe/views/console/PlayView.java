package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class PlayView {

    PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().write(this.playController);
        } while (!this.playController.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.playController.getActiveColor().name());
    }

}

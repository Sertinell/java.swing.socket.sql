package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.MachinePlayerController;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.UserPlayerController;

public class PlayView implements PlayerControllerVisitor {

    PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            playController.getCurrentPlayerController().accept(this);
            this.playController.next();
            new BoardView().write(this.playController);
        } while (!this.playController.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.playController.getActiveColor().name());
    }

    @Override
    public void visit(UserPlayerController userPlayerController) {
        new UserPlayerView(userPlayerController).interact();
    }

    @Override
    public void visit(MachinePlayerController machinePlayerController) {
        new MachinePlayerView(machinePlayerController).interact();
    }
}

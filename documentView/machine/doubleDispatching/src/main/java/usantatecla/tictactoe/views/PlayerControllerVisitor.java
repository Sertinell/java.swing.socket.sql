package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.*;


public interface PlayerControllerVisitor {
    void visit(UserPlayerController userPlayer);
    void visit(MachinePlayerController machinePlayer);
}

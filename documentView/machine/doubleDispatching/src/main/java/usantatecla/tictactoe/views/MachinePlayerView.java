package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.*;
import usantatecla.tictactoe.types.Coordinate;

class MachinePlayerView extends PlayerView {

    MachinePlayerView(MachinePlayerController machinePlayerController) {
        super(machinePlayerController);
    }

    @Override
    protected Coordinate getCoordinate(Message message) {
        Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
    }   
}

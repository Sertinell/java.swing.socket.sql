package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;
class MachinePlayerView extends PlayerView {
    @Override
    public Coordinate getCoordinate(Message message) {
        Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
    }
}

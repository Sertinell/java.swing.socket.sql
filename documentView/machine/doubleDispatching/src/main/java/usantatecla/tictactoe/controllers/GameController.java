package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class GameController {
    protected Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public Color getColor(Coordinate coordinate) {
    return game.getColor(coordinate);
    }
    
    public int getNumPlayers() {
    return game.getNumPlayers();
    }
}

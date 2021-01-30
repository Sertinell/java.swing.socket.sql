package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.GameController;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.views.Console;

class BoardView {

    void write(GameController gameController) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView().write(gameController.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}

package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class ErrorView {

    public static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong"
    };

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void writeln() {
        if (!error.isNull()) {
            Console.getInstance().writeln(this.MESSAGES[this.error.ordinal()]);
        }
    }

}

package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

public class ColorView {

    public void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
    
}

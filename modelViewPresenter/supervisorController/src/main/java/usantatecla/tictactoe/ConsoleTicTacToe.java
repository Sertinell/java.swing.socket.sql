package usantatecla.tictactoe;

import usantatecla.tictactoe.views.console.ConsoleViewFactory;

public class ConsoleTicTacToe extends TicTacToe {

    @Override
    protected ConsoleViewFactory createViewFactory() {
        return new ConsoleViewFactory();
    }

    public static void main(String[] args) {
        new ConsoleTicTacToe().play();
    }

}

package usantatecla.tictactoe;

import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerBuilder {

    private Color color;
    private String[] rows;
    private Player player;

    public PlayerBuilder() {
        this.rows = new String[]{
                "   ",
                "   ",
                "   "};
    }

    public PlayerBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public Player build() {
        Board board = new BoardBuilder().build();
        this.player = new Player(this.color, board);
        this.player = spy(this.player);
        this.putTokens();
        return this.player;
    }

    private void putTokens(){
        Board board = new BoardBuilder().rows(this.rows).build();
        List<Coordinate> coordinates = board.getCoordinates(this.color);
        while (coordinates.size() > 0) {
            Coordinate coordinate = coordinates.remove(0);
            doReturn(coordinate).when(this.player).getCoordinate(any());
            this.player.play();
        }
    }


}

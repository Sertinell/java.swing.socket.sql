package usantatecla.tictactoe.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayerController;
import usantatecla.tictactoe.types.Coordinate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerViewTest {

    final static Coordinate ORIGIN = new Coordinate(0, 0);
    final static Coordinate TARGET = new Coordinate(0, 1);

    protected PlayerController playerController;
    protected PlayerView playerView;

    @Test
    public void testGivenPlayerViewWhenInteractThenPutToken() {
        doReturn(PlayerViewTest.ORIGIN).when(playerView).getCoordinate(any());
        this.playerView.interact();
        verify(this.playerController).putToken(PlayerViewTest.ORIGIN);
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveToken() {
        doReturn(true).when(this.playerController).areAllTokensOnBoard();
        doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(playerView).getCoordinate(any());
        this.playerController.putToken(PlayerViewTest.ORIGIN);
        this.playerView.interact();
        verify(this.playerController).moveToken(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET);
    }

}

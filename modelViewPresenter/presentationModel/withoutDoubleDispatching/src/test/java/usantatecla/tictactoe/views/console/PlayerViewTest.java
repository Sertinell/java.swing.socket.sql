package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {

    final static Coordinate ORIGIN = new Coordinate(0, 0);
    final static Coordinate TARGET = new Coordinate(0, 1);

    protected PlayerView playerView;

    @Mock
    private Logic logic;

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.playerView = spy(new PlayerView(this.logic));
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenPutToken() {
        doReturn(PlayerViewTest.ORIGIN).when(playerView).getCoordinate(any());
        when(this.logic.areAllTokensOnBoard()).thenReturn(false);
        when(this.logic.getPutTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
        this.playerView.interact();
        verify(this.logic).putToken(PlayerViewTest.ORIGIN);
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveToken() {
        doReturn(true).when(this.logic).areAllTokensOnBoard();
        doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(playerView).getCoordinate(any());
        when(this.logic.getOriginMoveTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.logic.getTargetMoveTokenError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.NULL);
        this.logic.putToken(PlayerViewTest.ORIGIN);
        this.playerView.interact();
        verify(this.logic).moveToken(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET);
    }

    @Test
    public void testGivenUserPlayerViewWhenGetCoordinateThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(
                    PlayerViewTest.ORIGIN.getRow() + 1,
                    PlayerViewTest.ORIGIN.getColumn() + 1
            );
            assertThat(this.playerView.getCoordinate(Message.COORDINATE_TO_PUT), is(PlayerViewTest.ORIGIN));
        }
    }

}

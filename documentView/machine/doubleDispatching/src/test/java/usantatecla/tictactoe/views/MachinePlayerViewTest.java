package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;

import usantatecla.tictactoe.controllers.MachinePlayerController;
import usantatecla.tictactoe.models.PlayerBuilder;
import usantatecla.tictactoe.types.Color;

import static org.mockito.Mockito.spy;

public class MachinePlayerViewTest extends PlayerViewTest {

    @BeforeEach
    public void beforeEach() {
        this.playerController = new MachinePlayerController(new PlayerBuilder().color(Color.X).build());
        this.playerView = spy(new MachinePlayerView((MachinePlayerController) this.playerController));
    }

}

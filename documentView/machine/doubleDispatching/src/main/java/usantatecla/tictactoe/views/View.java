package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(StartController startController, PlayController playController, ResumeController resumeController){
        this.startView = new StartView(startController);
        this.playView = new PlayView(playController);
        this.resumeView = new ResumeView(resumeController);
    }

    public void interact() {
        do {
            this.startView.interact();
            this.playView.interact();
        } while (this.resumeView.interact());
    }
}

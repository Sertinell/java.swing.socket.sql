package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.interfaces.IPlayView;
import usantatecla.tictactoe.views.interfaces.IResumeView;
import usantatecla.tictactoe.views.interfaces.IStartView;

public class SessionController {
    private StartController 	startController;
	private ResumeController 	resumeController;
    private PlayController	 	playController;
    
    private IStartView startView;
    private IPlayView playView;
    private IResumeView resumeView;

    public SessionController(Game game, IStartView startView, IPlayView playView, IResumeView resumeView){
        this.startController = new StartController(game);
        this.playController = new PlayController(game);
        this.resumeController = new ResumeController(game);
        this.startView = startView;
        this.playView = playView;
        this.resumeView = resumeView;
    }

    public void run(){
        do{
            startController.run(startView);
            playController.run(playView);
        }while(resumeController.run(resumeView));
    }
}

package usantatecla.tictactoe.views;

import usantatecla.tictactoe.views.interfaces.IResumeView;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView implements IResumeView{


	@Override
	public boolean getResume() {
		YesNoDialog isResumed = new YesNoDialog();
		isResumed.read(Message.RESUME.toString());
		return isResumed.isAffirmative();
	}
}

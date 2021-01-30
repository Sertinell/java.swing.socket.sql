package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.views.PlayerControllerVisitor;

public class MachinePlayerController extends PlayerController {

	public MachinePlayerController(Player player){
		super(player);
	}

	@Override
	public void accept(PlayerControllerVisitor playerVisitor) {
		playerVisitor.visit(this);
	}

}

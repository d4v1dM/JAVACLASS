package simonDavid;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.ClickableScreen;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenDavid extends ClickableScreen implements Runnable {
	private ProgressInterfaceDavid progress; // what is the progress.
	private ArrayList<MoveInterfaceDavid> moves; // simons says?
	private int roundNum; // what round is it?
	private boolean valid; // input is valid?
	private TextLabel label; // text
	private int lastMove; // last number inputted.
	private ButtonInterfaceDavid[] validMoves; // possible moves.
	private int numOfButtons; // number of buttons on screen.
	public SimonScreenDavid(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceDavid>();
		//add 2 moves to start
		lastMove = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNum = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

	}

	private MoveInterfaceDavid randomMove() {
		// TODO Auto-generated method stub
		ButtonInterfaceDavid newMove; // new move that will be returned.
		newMove = validMoves[(int) (Math.random() * validMoves.length)];
		return getMove(newMove);
	}

	private MoveInterfaceDavid getMove(ButtonInterfaceDavid newMove) {
		// TODO Auto-generated method stub
		return null;
	}

	private ProgressInterfaceDavid getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		Color[] colors = new Color[
		for(int i = 0; i < numOfButtons; ++i){
			colors[i] = new Color((int) Math.random() * 255,(int) Math.random() * 255,(int) Math.random() * 255);
		}
	}

}

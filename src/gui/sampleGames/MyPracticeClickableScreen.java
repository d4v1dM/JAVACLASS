package gui.sampleGames;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableScreen;
import gui.components.Visible;

public class MyPracticeClickableScreen extends ClickableScreen {
	private Button button;

	public MyPracticeClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		button = new Button(20,100, 100,40,"The Button", Color.orange, new Action(){
			public void act(){
				System.out.println("Changeddd!!");
				//MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		viewObjects.add(button);
	}

}

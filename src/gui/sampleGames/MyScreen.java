package gui.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;
import gui.screens.CoordinateScreen;

public class MyScreen extends Screen implements MouseListener{

	public Button myButton;
	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		myButton = new Button(100,100,200,200,"helllo",Color.pink,new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				MouseFollower.game.setScreen(MouseFollower.cs);
			}
		});
		viewObjects.add(myButton);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(myButton.isHovered(e.getX(), e.getY())){
			myButton.act();
		}
	}
	@Override
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphic;
import gui.components.ClickableScreen;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;
import gui.sampleGames.MyPracticeClickableScreen;

public class CoordinateScreen extends Screen implements MouseListener{
	private ClickableGraphic alonzo;
	private TextLabel text;
	private Button button;
	private TextArea textA;
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20,200,500,40,"Some text");
		viewObjects.add(text);
		/*button = new Button(20,100, 100,40,"The Button", Color.orange, new Action(){
			public void act(){
				System.out.println("Changeddd!!");
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		viewObjects.add(button);*/
		textA = new TextArea(40,85,550,100,"This is a whole paragraph. Notice how as the paragraph gets to the edge of the page,"
				+ " a new line is created.");
		//viewObjects.add(textA);
		alonzo = new ClickableGraphic(30, 30, .5, "resources/sampleImages/alanzo.png");
		alonzo.setAction(new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				alonzo.setX(alonzo.getx() + 10);
				alonzo.setY(alonzo.gety() + 10);
				System.out.println("GRAAPHIC WAS CLICKED.");
				//MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		viewObjects.add(alonzo);
	}
	public void mouseDragged(MouseEvent event) {
		
	}

	public void mouseMoved(MouseEvent event) {
		text.setText("Mouse at " +event.getX() +" and at "+event.getY());
		text.setX(event.getX());
		text.setY(event.getY());
	}/*
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*if(button.isHovered(e.getX(), e.getY())){
			button.act();
		}*/
		if(alonzo.isHovered(e.getX(), e.getY())){
			alonzo.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
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
	@Override
	public MouseListener getMouseListener(){
		return this;
	}

}

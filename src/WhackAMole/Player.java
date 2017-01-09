package WhackAMole;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Components;

public class Player extends Components implements PlayerInterface {
	private int score;

	public Player() {
		super(20, 20, 100, 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increaseScore(int i) {
		// TODO Auto-generated method stub
		score += i; // update score.
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(200,200,255));
		g.fillOval(0, 0, 99, 99);
		g.setColor(Color.black);
		g.drawOval(0, 0, 99, 99);
		g.drawString("Score = " + score, 20, 55);
	}

}
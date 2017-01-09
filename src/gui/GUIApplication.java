package gui;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import gui.sampleGames.MyScreen;
import gui.screens.CoordinateScreen;

public abstract class GUIApplication extends JFrame implements Runnable{
	private Screen currentScreen;
	public GUIApplication(int width, int height){
		super();
		setBounds(20,20,width,height);
		//20,20 = coordinates it appears
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Calls it in MouseFollower
		initScreen();
		setVisible(true);
	}

	public abstract void initScreen();
//	public static void main(String[] args){
//		new GUIApplication(800,600);
//		new Screen(800,600);
//	}
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(),0,0,null);
	}

	public void setScreen(Screen myScreen) {
		if(currentScreen!=null){
			MouseListener ml = currentScreen.getMouseListener();
			if(ml != null){
				removeMouseListener(ml);
			}
			MouseListener mml = currentScreen.getMouseListener();
			if(mml!=null){
				removeMouseListener(mml);
			}
		}
		this.currentScreen = myScreen;
		if(currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
		}
	}
	public void run(){
		while(true){
			currentScreen.update();
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

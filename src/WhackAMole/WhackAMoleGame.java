package WhackAMole;

import gui.GUIApplication;

public class WhackAMoleGame extends GUIApplication {

	public WhackAMoleGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		WhackAMoleScreen wams = new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(wams);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhackAMoleGame wamg = new WhackAMoleGame(800,500); // make game instance
		Thread game = new Thread(wamg); // make a thread with the game process
		game.start(); // execute the thread.
		
	}

}

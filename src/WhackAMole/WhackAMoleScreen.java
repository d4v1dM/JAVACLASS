package WhackAMole;

import java.util.ArrayList;

import gui.components.Action;
import gui.components.ClickableScreen;
import gui.components.TextLabel;
import gui.components.Visible;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		timeLeft = 30;
		// when making Simon, creating a thread like this, is neccessary,
		// since Simon's screen changes.
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(350,220,100,40,"Sample Text");
		timeLabel = new TextLabel(360, 40, 80, 40, "30.0");
		viewObjects.add(player);
		viewObjects.add(timeLabel);
		viewObjects.add(label);
	}
	public PlayerInterface getAPlayer(){
		return new Player();
	}
	public  MoleInterface getAMole(){
		return new Mole((int) Math.random() * getWidth(), (int) (Math.random() * getHeight()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		changeText("Ready..");
		changeText("Set...");
		changeText("Go..");
		label.setText("");
		while(timeLeft > 0){
			updateTimer();
			updateAllMoles();
			appearNewMole();
		}
	}
	private void appearNewMole(){
		double chance = .1 * ((60 - timeLeft)/60);
		
		if(Math.random() < chance){
			// create a mole
			final MoleInterface mole = getAMole();
			mole.setAppearanceTime((int)(500 + Math.random() * 2000));
			mole.setAction(new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
				}
			});
			addObject(mole);
			moles.add(mole);
		}
	}
	private void updateAllMoles() {
		// TODO Auto-generated method stub
		for(int i = 0; i < moles.size(); ++i){
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime() - 100;
			m.setAppearanceTime(screenTime);
			
			if(m.getAppearanceTime() <= 0){
				remove(m); // remove from the screen.
				moles.remove(m);
				--i;
			}
		}
	}

	private void updateTimer() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeLeft -= .1;
		timeLabel.setText("" + (int)(timeLeft*10)/10.0);
	}

	// will be using for Simon says.
	private void changeText(String string) {
		// TODO Auto-generated method stub
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

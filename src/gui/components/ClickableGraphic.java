package gui.components;

public class ClickableGraphic extends Graphic implements Clickable{
	private Action myAct;

	public ClickableGraphic(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public ClickableGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public ClickableGraphic(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public boolean isHovered(int x, int y) {
		return (x > getx() && x < getx()+getWidth() && y > gety() && y < gety()+getHeight());
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if(myAct == null) return;
		this.myAct.act();
	}
	public void setAction(Action a){
		myAct = a;
	}
}

package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Visible;

public abstract class Screen {
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}
	public abstract void initObjects(ArrayList<Visible> viewObjects);
	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}
	public BufferedImage getImage(){
		return image;
	}
	public int getWidth(){
		return image.getWidth();
	}
	public int getHeight(){
		return image.getHeight();
	}
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0,0,image.getWidth(),image.getHeight());
		//for(Visible v: viewObjects){
			//g.drawImage(v.getImage(), v.getx(), v.gety(),null);
		//}
		
		for(int i = 0; i < viewObjects.size(); ++i){
			g.drawImage(viewObjects.get(i).getImage(), viewObjects.get(i).getx() , viewObjects.get(i).gety(), null);
		}	
//		g.setColor(Color.black);
//		g.drawString("Hello World!",  49, 100);
//		g.drawOval(30, 70, 100, 50);
	}
	public MouseMotionListener getMouseMotionListener(){
		
		return null;
	}
	public MouseListener getMouseListener(){
		
		return null;
	}
	public void addObject(Visible v) {
		// TODO Auto-generated method stub
		viewObjects.add(v);
	}
	public void remove(Visible v) {
		// TODO Auto-generated method stub
		/*
		 *  NOTE: In this implementation, we have a very simple
		 *  	command: remove(v)
		 *  	however, remove is sort of a big deal on the
		 *  	AP Exam. Here's why:
		 *  	
		 *  	When an object  is removed from a LIST, every other 
		 *  	object AFTER that object is moved up in order.
		 *  	Therefore, all of their respective indices change.
		 *  	You MUST, MUST MUST be aware of this.
		 *  
		 *  
		 *  	Here is a classic example:
		 *  	The following is WRONG
		 *  	Suppose you have  a List<Integer> with
		 *  	------> {4,8,7,1}
		 *  	
		 *  	for(int i = 0; i < list.size(); ++i){
		 *  		if(list[i] > 5) list.remove(i);
		 *  	}
		 *  
		 *  	removing items will shift the items.
		 *  	i will now have to adapt to the shifting
		 *  	but it doesn't.
		 *  
		 *  	by decreasing i when you remove an item
		 *  		---> you'll adapt the iterator.
		 */
		viewObjects.remove(v);
	}
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			// the back is index
			viewObjects.add(0,v);
		}
	}
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
}
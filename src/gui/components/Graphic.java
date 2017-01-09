 package gui.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Graphic implements Visible {
	private BufferedImage image;
	private boolean loadedImages;
	private int x;
	private int y;

	// full size graphics constructor
	public Graphic(int x, int y,String imageLocation) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, 0, 0);
	}
	
	// costume size graphics constructor
	public Graphic(int x, int y, int w, int h, String imageLocation) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, w, h);
	}
	
	// costume size graphics constructor
	public Graphic(int x, int y, double scale, String imageLocation) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, scale);
	}
	private void loadImages(String imageLocation, double scale) {
			// TODO Auto-generated method stub
			try{
				ImageIcon icon = new ImageIcon(imageLocation);
				int newWidth = (int) (icon.getIconWidth() * scale);
				int newHeight = (int) (icon.getIconHeight() * scale);
				image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, newWidth, newHeight, 0, 0, icon.getIconWidth(), icon.getIconHeight(), null);

			}catch(Exception e){
				e.printStackTrace();
			}
	}
	private void loadImages(String imageLocation, int w, int h) {
		// TODO Auto-generated method stub
		try{
			// full size image.
			ImageIcon icon = new ImageIcon(imageLocation);
			if(w <= 0 && h <= 0){
				// use full size icon.
				image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
				// use the graphics2D tool to copy the icon.
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
			}
			else{
				// use costume size icon.
				// use full size icon.
				image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				// use the graphics2D tool to copy the icon.
				Graphics2D g = image.createGraphics();
				// note --> this is how you crop.
				g.drawImage(icon.getImage(), 0, 0, w, h, 0, 0, icon.getIconWidth(), icon.getIconHeight(), null);
				
			}
			loadedImages = true; // image has been loaded.
		}catch(Exception e){
			// this happens, when you don't name the image correctly
			e.printStackTrace();
		}
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public int getx() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int gety(){
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setX(int x){
		this.x = x;
		update();
	}
	public void setY(int y){
		this.y = y;
		update();
	}

	@Override
	public void update() {
		// does nothing.
	}
}
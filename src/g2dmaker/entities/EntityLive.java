package g2dmaker.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class EntityLive extends EntityObject {
	
	protected double speed;
	protected int direction;

	public EntityLive(int x, int y, BufferedImage sprite, boolean solid) {
		super(x, y, sprite, solid);
		speed = 1;
		direction = 0;
	}
	
	public EntityLive(int x, int y, BufferedImage sprite, boolean solid, double speed) {
		super(x, y, sprite, solid);
		this.speed = speed;
	}
	
	public void setSpeed(final double speed) {
		this.speed = speed;
	}

	public void move(final int x, final int y) {
		int tempX = this.x;
		int tempY = this.y;
		this.x += x * speed;
		this.y += y * speed;
		if(solid) {
			updateCollitions();
		}
		// valor negativo significa que se mueve en direccion "negativa", hacia arriba o la izquierda
		if(tempX > this.x) {
			direction = -1;
		} else if(tempX < this.x) {
			direction = -1;
		} else if(tempY > this.y) {
			direction = 1;
		} else if(tempY < this.y) {
			direction = 1;
		} else {
			direction = 0;
		}
	}
	
	public int getDirection() {
		return direction;
	}
	
	protected void updateCollitions() {
		collitionTop.x = this.x + limitCollitionX;
		collitionTop.y = this.y + limitCollitionY;
		
		collitionBottom.x = this.x + limitCollitionX;
		collitionBottom.y = this.y + limitCollitionHeight;
		
		collitionLeft.x = this.x + limitCollitionX;
		collitionLeft.y = this.y;
		
		collitionRight.x = this.x + limitCollitionWidth + limitCollitionX;
		collitionRight.y = this.y;
	}
	
	public boolean isCollitionTop(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle area = collitionsArea.get(i);
			int originX = area.x;
			int originY = (int) (area.y + speed);

			final Rectangle futureArea = new Rectangle(originX, originY, (int) area.getWidth(), (int) area.getHeight());
			if (collitionTop.intersects(futureArea)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionBottom(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			Rectangle area = collitionsArea.get(i);
			int originX = area.x;
			int originY = (int) (area.y - speed);

			final Rectangle futureArea = new Rectangle(originX, originY, (int) area.getWidth(), (int) area.getHeight());
			if (collitionBottom.intersects(futureArea)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionLeft(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			Rectangle area = collitionsArea.get(i);
			int originX = (int) (area.x + speed);
			int originY = area.y;

			final Rectangle futureArea = new Rectangle(originX, originY, (int) area.getWidth(), (int) area.getHeight());
			if (collitionLeft.intersects(futureArea)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionRight(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			Rectangle area = collitionsArea.get(i);
			int originX = (int) (area.x - speed);
			int originY = area.y;

			final Rectangle futureArea = new Rectangle(originX, originY, (int) area.getWidth(), (int) area.getHeight());
			if (collitionRight.intersects(futureArea)) {
				return true;
			}
		}
		return false;
	}
	
}

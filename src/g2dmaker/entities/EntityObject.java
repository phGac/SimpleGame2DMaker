package g2dmaker.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class EntityObject extends Entity {

	protected Rectangle collitionTop;
	protected Rectangle collitionBottom;
	protected Rectangle collitionLeft;
	protected Rectangle collitionRight;
	
	protected int limitCollitionX;
	protected int limitCollitionY;
	protected int limitCollitionWidth;
	protected int limitCollitionHeight;
	
	protected boolean solid;
	
	protected boolean gravity;
	
	public EntityObject(final int x, final int y, final BufferedImage sprite, boolean solid) {
		super(x, y, sprite);
		this.solid = solid;
		gravity = false;
	}
	
	public EntityObject(final int x, final int y, final BufferedImage sprite, boolean solid, boolean gravity) {
		super(x, y, sprite);
		this.solid = solid;
		this.gravity = gravity;
	}
	
	public void drawCollitionLimits(final Graphics g) {
		g.drawRect(collitionTop.x, collitionTop.y, (int) collitionTop.getWidth(), (int) collitionTop.getHeight());
		g.drawRect(collitionBottom.x, collitionBottom.y, collitionBottom.width, collitionBottom.height);
		g.drawRect(collitionLeft.x, collitionLeft.y, collitionLeft.width, collitionLeft.height);
		g.drawRect(collitionRight.x, collitionRight.y, collitionRight.width, collitionRight.height);
	}
	
	public boolean isCollition(final Rectangle r) {
		if (collitionTop.intersects(r))
			return true;
		if(collitionBottom.intersects(r))
			return true;
		if(collitionLeft.intersects(r))
			return true;
		if(collitionRight.intersects(r))
			return true;
		
		return false;
	}
	
	public boolean isCollitionTop(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle area = collitionsArea.get(i);
			if (collitionTop.intersects(area)) {
				System.out.println("TRUE");
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionBottom(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle area = collitionsArea.get(i);
			if (collitionBottom.intersects(area)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionLeft(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle area = collitionsArea.get(i);
			if (collitionLeft.intersects(area)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCollitionRight(final ArrayList<Rectangle> collitionsArea) {
		for(int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle area = collitionsArea.get(i);
			if (collitionRight.intersects(area)) {
				return true;
			}
		}
		return false;
	}
	
	protected void setCollition() {
		setCollitionLimits(0, 0, 0, 0);
		collitionTop = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
		collitionBottom = new Rectangle();
	}
	
	protected void setCollition(int x, int y) {
		setCollitionLimits(x, y, 0, 0);
		x += this.x;
		y += this.y;
		collitionTop = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	protected void setCollition(int x, int y, int width, int height) {
		width += sprite.getWidth() - x;
		height += sprite.getHeight() - y;
		setCollitionLimits(x, y, width, height);
		x += this.x;
		y += this.y;
		
		collitionTop = new Rectangle(x, y, width, 1);
		collitionBottom = new Rectangle(x, y + height, width, 1);
		collitionLeft = new Rectangle(x, y, 1, height);
		collitionRight = new Rectangle(x + width, y, 1, height);
	}
	
	private void setCollitionLimits(final int x, final int y, final int width, final int height) {
		limitCollitionX = x;
		limitCollitionY = y;
		limitCollitionWidth = width;
		limitCollitionHeight = height;
	}
	
	public Rectangle getCollitionTop() {
		return collitionTop;
	}
	public Rectangle getCollitionBottom() {
		return collitionBottom;
	}
	public Rectangle getCollitionLeft() {
		return collitionLeft;
	}
	public Rectangle getCollitionRight() {
		return collitionRight;
	}
	
}

package g2dmaker.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected int x;
	protected int y;
	
	protected BufferedImage sprite;
	
	public Entity() {
	}
	
	public Entity(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public Entity(final int x, final int y, final BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void draw(final Graphics g) {
		g.drawImage(sprite, x, y, null);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(final int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(final int y) {
		this.y = y;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
}

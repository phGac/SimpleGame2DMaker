package g2dmaker.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class EntityObjectSimple extends Entity {

	protected Rectangle collition;
	
	protected boolean solid;
	
	public EntityObjectSimple(final int x, final int y, final BufferedImage sprite) {
		super(x, y, sprite);
	}
	
	public void drawCollitionLimits(final Graphics g) {
		g.drawRect(collition.x, collition.y, (int) collition.getWidth(), (int) collition.getHeight());
	}
	
	protected void setCollition() {
		collition = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	protected void setCollition(int x, int y) {
		x += this.x;
		y += this.y;
		collition = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	protected void setCollition(int x, int y, int width, int height) {
		width += sprite.getWidth() - x;
		height += sprite.getHeight() - y;
		x += this.x;
		y += this.y;
		
		collition = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getCollition() {
		return collition;
	}
	
}

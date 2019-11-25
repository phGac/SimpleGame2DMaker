package samples.nibbles.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Snake extends EntityLive {
	
	private int size = 0;
	
	private int[][] tail = new int[20][2];

	public Snake(int x, int y, BufferedImage sprite, boolean solid, double speed) {
		super(x, y, sprite, solid, speed);
		setCollition(0, 0, 0, 0);
		
		tail[0][0] = x;
		tail[0][1] = y;
		size++;
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < size; i++) {
			int x = tail[i][0];
			int y = tail[i][1];
			g.drawImage(sprite, x, y, null);
		}
	}
	
	public void move(final int x, final int y) {
		this.x += x * speed;
		this.y += y * speed;
		updateCollitions();
		updateTail(x, y);
	}
	
	private void updateTail(final int x, final int y) {
		for(int i = 0; i < size; i++) {
			tail[i][0] += x * speed;
			tail[i][1] += y * speed;
		}
	}
	
	public void eat() {
		tail[size][0] = x;
		tail[size][1] = y;
		size++;
		updateTail(x, y);
	}
	
	public void die() {
		x = 200;
		y = 200;
	}
	
	public int getSize() {
		return size;
	}

}

package samples.typespeed.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Word extends EntityLive {
	
	private String word;

	public Word(int x, int y, BufferedImage sprite, boolean solid, double speed, String word) {
		super(x, y, sprite, solid, speed);
		this.word = word;
	}
	
	public void draw(Graphics g) {
		g.drawString(word, x, y);
	}
	
	public String getWord() {
		return word;
	}

}

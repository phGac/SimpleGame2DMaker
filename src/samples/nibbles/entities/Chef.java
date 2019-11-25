package samples.nibbles.entities;

import java.awt.Graphics;

import g2dmaker.entities.Entity;
import samples.nibbles.ConstantsNibbles;

public class Chef extends Entity {
	
	private static Food food = null;

	public void draw(Graphics g) {
		if(food != null) {
			food.draw(g);
		}
	}
	
	public void cook() {
		if(food == null) {
			int x = (int) (Math.random()*100) +20;
			int y = (int) (Math.random()*100) +20;
			System.out.println("> x:"+x);
			System.out.println("> y:"+y);
			food = new Food(x, y, ConstantsNibbles.NIBBLES_SHEET.getSprite(3, 0));
		}
	}
	
	public void eaten() {
		food = null;
	}
	
	public Food getFood() {
		return food;
	}
	
	public boolean isCooked() {
		return (food != null);
	}
	
}

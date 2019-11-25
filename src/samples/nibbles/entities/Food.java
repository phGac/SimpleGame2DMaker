package samples.nibbles.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityObjectSimple;

public class Food extends EntityObjectSimple {

	public Food(final int x, final int y, BufferedImage sprite) {
		super(x, y, sprite);
		setCollition();
	}
	
}

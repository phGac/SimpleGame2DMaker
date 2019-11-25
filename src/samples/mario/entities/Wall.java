package samples.mario.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityObject;

public class Wall extends EntityObject {

	public Wall(int x, int y, BufferedImage sprite, boolean solid) {
		super(x, y, sprite, solid);
	}

}

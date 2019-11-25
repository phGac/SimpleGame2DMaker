package samples.mario.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Player extends EntityLive {

	public Player(int x, int y, BufferedImage sprite, boolean solid, double speed) {
		super(x, y, sprite, solid, speed);
		setCollition(0,0,0,0);
	}

}

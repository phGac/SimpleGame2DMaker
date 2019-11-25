package samples.pong.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Player extends EntityLive {

	public Player(final int x, final int y, final BufferedImage sprite, final boolean solid, final double speed) {
		super(x, y, sprite, solid, speed);
		setCollition(10, 0, -10, 0);
	}

}

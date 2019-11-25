package samples.pong.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Opponent extends EntityLive {

	public Opponent(final int x, final int y, final BufferedImage sprite, final boolean solid, final double speed) {
		super(x, y, sprite, solid, speed);
		setCollition(10, 0, -10, 0);
	}

}

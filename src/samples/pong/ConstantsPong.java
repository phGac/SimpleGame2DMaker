package samples.pong;

import g2dmaker.graphics.sprite.SpriteSheet;
import samples.pong.control.KeyBoard;

public final class ConstantsPong {

	public static final KeyBoard KEYBOARD = new KeyBoard();
	public static final SpriteSheet SHEET_ENTITY = new SpriteSheet("/images/entity/player.png", 32, 64);
	public static final SpriteSheet SHEET_PONG = new SpriteSheet("/images/textures/pong.png", 32);
	
}

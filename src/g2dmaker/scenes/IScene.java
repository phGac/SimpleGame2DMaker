package g2dmaker.scenes;

import java.awt.Graphics;

import g2dmaker.managers.ScenesManager;

public interface IScene {
	public void update(final ScenesManager manager);
	public void draw(final Graphics g);
}

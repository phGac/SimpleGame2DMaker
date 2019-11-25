package g2dmaker.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import g2dmaker.managers.ScenesManager;

public class DrawSpace extends Canvas {

	private static final long serialVersionUID = 8414554139354649994L;

	public DrawSpace(final int width, final int height) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}

	public void draw(final ScenesManager manager) {
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.BLACK);

		manager.draw(g);
		Toolkit.getDefaultToolkit().sync();

		g.dispose();
		buffer.show();
	}

}

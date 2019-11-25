package g2dmaker.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

public class UI {
	
	public static void drawBar(int x, int y, int value, int max, int width, int height, Color color, Graphics g) {
		int w = width * value / max;
		int heightInSide = (int) (height * 0.3);
		
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width + 1, height);

		g.setColor(color.brighter());
		g.fillRect(x + 1, y + 1, w, heightInSide);

		g.setColor(color);
		g.fillRect(x + 1, y + heightInSide, w, height - heightInSide);
	}

	public static void drawBar(int x, int y, int value, int max, int width, Color color, Graphics g) {
		int height = (int) (width * 0.1);
		drawBar(x, y, value, max, width, height, color, g);
	}
	
	public static void drawBarRed(int x, int y, int value, int max, int width, Graphics g) {
		drawBar(x, y, value, max, width, new Color(153, 0, 0), g);
	}
	
	public static void drawBarBlue(int x, int y, int value, int max, int width, Graphics g) {
		drawBar(x, y, value, max, width, new Color(0x131dcf), g);
	}

}

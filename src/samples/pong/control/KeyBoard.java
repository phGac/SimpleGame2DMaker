package samples.pong.control;

import java.awt.event.KeyEvent;

import g2dmaker.control.IKeyBoard;

public class KeyBoard implements IKeyBoard {

	private final static int numberKeys = 120;
	private final boolean[] keys = new boolean[numberKeys];

	public boolean up = keys[KeyEvent.VK_W];
	public boolean down = keys[KeyEvent.VK_S];
	public boolean left = keys[KeyEvent.VK_A];
	public boolean right = keys[KeyEvent.VK_D];

	public boolean enter = keys[KeyEvent.VK_ENTER];

	public boolean exit = keys[KeyEvent.VK_ESCAPE];
	
	@Override
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		enter = keys[KeyEvent.VK_ENTER];

		exit = keys[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}

package samples.typespeed.control;

import java.awt.event.KeyEvent;

import g2dmaker.control.IKeyBoard;

public class KeyBoard implements IKeyBoard {
	
	private final static int numberKeys = 120;
	private final boolean[] keys = new boolean[numberKeys];
	
	public boolean enter = keys[KeyEvent.VK_ENTER];
	
	public String text = "";

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_CAPS_LOCK && e.getKeyCode() != KeyEvent.VK_ENTER)
			text += e.getKeyChar();
		else if(text.length() > 0 && e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_ENTER)
			text = text.substring(0, text.length()-1);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			text = "";
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void update() {
		enter = keys[KeyEvent.VK_ENTER];
	}

}

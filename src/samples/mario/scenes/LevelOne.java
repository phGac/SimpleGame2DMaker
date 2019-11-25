package samples.mario.scenes;

import java.awt.Color;
import java.awt.Graphics;

import g2dmaker.managers.ScenesManager;
import g2dmaker.scenes.Scene;
import samples.mario.ConstantsMario;
import samples.mario.entities.Player;

public class LevelOne extends Scene {
	
	Player player = new Player(200, 200, ConstantsMario.SHEET.getSprite(5, 1), true, 1.5);
	
	public LevelOne(String pathMap, int sidePerSprite) {
		super(pathMap, sidePerSprite);
	}

	@Override
	public void update(ScenesManager manager) {
		
		if(ConstantsMario.KEYBOARD.space && (! player.isCollitionTop(map.collitionsArea))) {
			player.move(0, -1);
		}
		if(ConstantsMario.KEYBOARD.left && (! player.isCollitionLeft(map.collitionsArea))) {
			player.move(-1, 0);
		}
		if(ConstantsMario.KEYBOARD.right && (! player.isCollitionRight(map.collitionsArea))) {
			player.move(1, 0);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		map.draw(g);
		player.draw(g);
		
		int playerX = player.getX();
		int playerY = player.getY();
		g.setColor(Color.WHITE);
		g.drawString("Player["+playerX+", "+playerY+"]", 550, 30);
		
		g.setColor(Color.RED);
		map.drawCollitionsArea(g);
	}

}

package samples.nibbles.scenes;

import java.awt.Color;
import java.awt.Graphics;

import g2dmaker.managers.ScenesManager;
import g2dmaker.scenes.Scene;
import samples.nibbles.ConstantsNibbles;
import samples.nibbles.entities.Chef;
import samples.nibbles.entities.Snake;
import samples.nibbles.entities.Stadistics;

public class Board extends Scene {
	
	private static Chef chef = new Chef();
	private final Snake snake = new Snake(150, 180, ConstantsNibbles.NIBBLES_SHEET.getSprite(0, 0), true, 1.3);
	private final Stadistics stadistics = new Stadistics();
	
	private int lastMoveX = 1;
	private int lastMoveY = 0;

	public Board(String pathMap, int sidePerSprite) {
		super(pathMap, sidePerSprite);
	}
	
	private void checkCollitionMap() {
		if(snake.isCollitionTop(map.collitionsArea) ||
				snake.isCollitionBottom(map.collitionsArea) ||
				snake.isCollitionLeft(map.collitionsArea) ||
				snake.isCollitionRight(map.collitionsArea)) 
		{
			lastMoveX = 0;
			lastMoveY = 0;
			stadistics.lessLive();
			snake.die();
		}
		
	}
	
	private void checkCollitionFood() {
		if(chef.isCooked()) {
			if(snake.isCollition(chef.getFood().getCollition())) {
				snake.eat();
				chef.eaten();
				stadistics.addPoint();
			}
		}
	}
	
	private void updateMoveSnake() {
		if(! stadistics.isDead()) {
			if(ConstantsNibbles.KEYBOARD.up && lastMoveY != 1) {
				lastMoveX = 0;
				lastMoveY = -1;
			} else if(ConstantsNibbles.KEYBOARD.right && lastMoveX != -1) {
				lastMoveX = 1;
				lastMoveY = 0;
			} else if(ConstantsNibbles.KEYBOARD.down && lastMoveY != -1) {
				lastMoveX = 0;
				lastMoveY = 1;
			} else if(ConstantsNibbles.KEYBOARD.left && lastMoveX != 1) {
				lastMoveX = -1;
				lastMoveY = 0;
			}
		}
	}

	@Override
	public void update(ScenesManager manager) {
		checkCollitionFood();
		checkCollitionMap();
		chef.cook();
		snake.move(lastMoveX, lastMoveY);
		updateMoveSnake();
	}

	@Override
	public void draw(final Graphics g) {
		map.draw(g);
		chef.draw(g);
		snake.draw(g);
		
		g.setColor(Color.WHITE);
		stadistics.draw(g);
		
		if(stadistics.isDead()) {
			g.drawString("You died.", 150, 150);
		}
		
		map.drawCollitionsArea(g);
		chef.getFood().drawCollitionLimits(g);
		snake.drawCollitionLimits(g);
	}

}

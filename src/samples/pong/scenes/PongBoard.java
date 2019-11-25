package samples.pong.scenes;

import java.awt.Color;
import java.awt.Graphics;

import g2dmaker.managers.ScenesManager;
import g2dmaker.scenes.Scene;
import samples.pong.ConstantsPong;
import samples.pong.entities.Ball;
import samples.pong.entities.Opponent;
import samples.pong.entities.Player;

public class PongBoard extends Scene {
	
	private Player player = new Player(600, 220, ConstantsPong.SHEET_ENTITY.getSprite(0,0), true, 5);
	private Opponent opponent = new Opponent(40, 220, ConstantsPong.SHEET_ENTITY.getSprite(1,0), true, 2);
	private Ball ball = new Ball(320, 230, ConstantsPong.SHEET_PONG.getSprite(4, 0), true, 1);
	
	public PongBoard(String pathMap, int sidePerSiprite) {
		super(pathMap, sidePerSiprite);
	}

	@Override
	public void update(final ScenesManager manager) {
		ball.move();
		
		if((ball.getX() < 0 && ball.getDirection() < 0)) {
			ball.flipMeaning();
		}
		
		if(ConstantsPong.KEYBOARD.exit) {
			manager.setActualScene("main");
		}
		if(ConstantsPong.KEYBOARD.up && (! player.isCollitionTop(map.collitionsArea))) {
			player.move(0, -1);
		}
		if(ConstantsPong.KEYBOARD.down && (! player.isCollitionBottom(map.collitionsArea))) {
			player.move(0, 1);
		}
	}

	@Override
	public void draw(Graphics g) {
		map.draw(g);
		player.draw(g);
		opponent.draw(g);
		ball.draw(g);
		
		int playerX = player.getX();
		int playerY = player.getY();
		g.setColor(Color.WHITE);
		g.drawString("Player["+playerX+", "+playerY+"]", 550, 30);
		
		int opponentX = opponent.getX();
		int opponentY = opponent.getY();
		g.drawString("Opponent["+opponentX+", "+opponentY+"]", 20, 30);
		
		int ballX = ball.getX();
		int ballY = ball.getY();
		g.drawString("Ball["+ballX+", "+ballY+"]", 100, 100);
		
		g.setColor(Color.RED);
		map.drawCollitionsArea(g);
		player.drawCollitionLimits(g);
		opponent.drawCollitionLimits(g);
		ball.drawCollitionLimits(g);
	}

}

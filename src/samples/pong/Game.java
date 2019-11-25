package samples.pong;

import g2dmaker.G2DMaker;
import samples.pong.scenes.PongBoard;

public class Game extends G2DMaker {
	
	public Game(final String title, final int width, final int height, final int maxMapsInMemory) {
		super(title, width, height, maxMapsInMemory);
	}
	
	public static void main(String[] args) {
		PongBoard pong = new PongBoard("/maps/pong.map", 32);
		
		Game game = new Game("Pong", 672, 480, 2);
		game.addKeyBoard(ConstantsPong.KEYBOARD);
		game.addScene("pong", pong);
		game.setActualScene("pong");
		game.init();
	}
	
	protected void update() {
		ConstantsPong.KEYBOARD.update();
		scenesManager.update();
	}

}

package samples.mario;

import g2dmaker.G2DMaker;
import samples.mario.scenes.LevelOne;

public class Game extends G2DMaker {

	public Game(String title, int width, int height) {
		super(title, width, height);
	}

	public static void main(String[] args) {
		LevelOne level = new LevelOne("/maps/mario.map", 32);
		Game game = new Game("Mario Bros", 672, 480);
		game.addKeyBoard(ConstantsMario.KEYBOARD);
		game.addScene("level", level);
		game.setActualScene("level");
		game.init();
	}
	
	@Override
	public void update() {
		ConstantsMario.KEYBOARD.update();
		scenesManager.update();
	}

}

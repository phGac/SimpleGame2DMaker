package samples.typespeed;

import g2dmaker.G2DMaker;
import samples.typespeed.scenes.Board;

public class Game extends G2DMaker {
	
	public static void main(String[] args) {
		Board board = new Board("/maps/nibbles.map", 16);
		Game game = new Game();
		game.addKeyBoard(ConstantsTypeSpeed.KEYBOARD);
		game.addScene("board", board);
		game.setActualScene("board");
		game.init();
	}
	
	public void update() {
		ConstantsTypeSpeed.KEYBOARD.update();
		scenesManager.update();
	}

}

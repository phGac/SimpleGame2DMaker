package samples.nibbles;

import g2dmaker.G2DMaker;
import samples.nibbles.scenes.Board;

public class Game extends G2DMaker {

	public Game(String title, int width, int height, int maxMapsInMemory) {
		super(title, width, height, maxMapsInMemory);
	}
	
	public static void main(String[] args) {
		Board board = new Board("/maps/nibbles.map", 16);
		
		Game game = new Game("Nibbles", 320, 320, 2);
		game.addKeyBoard(ConstantsNibbles.KEYBOARD);
		game.addScene("board", board);
		game.setActualScene("board");
		game.init();
	}
	
	@Override
	public void update() {
		ConstantsNibbles.KEYBOARD.update();
		scenesManager.update();
	}
}

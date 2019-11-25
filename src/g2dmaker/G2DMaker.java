package g2dmaker;

import g2dmaker.control.IKeyBoard;
import g2dmaker.graphics.DrawSpace;
import g2dmaker.graphics.WindowScreen;
import g2dmaker.managers.ScenesManager;
import g2dmaker.scenes.Scene;
import g2dmaker.tools.ProyectInfo;

public abstract class G2DMaker {
	
	protected boolean running = false;
	
	protected static DrawSpace drawSpace;
	protected static WindowScreen windowScreen;
	protected static ScenesManager scenesManager;
	
	public G2DMaker() {
		ProyectInfo.setInfo();
		
		String title = ProyectInfo.get("window.title");
		int width = Integer.parseInt(ProyectInfo.get("window.width"));
		int height = Integer.parseInt(ProyectInfo.get("window.height"));
		
		drawSpace = new DrawSpace(width, height);
		windowScreen = new WindowScreen(title, drawSpace);
		scenesManager = new ScenesManager(3);
	}
	
	public G2DMaker(final int maxMapsInMemory) {
		ProyectInfo.setInfo();
		
		String title = ProyectInfo.get("window.title");
		int width = Integer.parseInt(ProyectInfo.get("window.width"));
		int height = Integer.parseInt(ProyectInfo.get("window.height"));
		
		drawSpace = new DrawSpace(width, height);
		windowScreen = new WindowScreen(title, drawSpace);
		scenesManager = new ScenesManager(3);
	}
	
	public G2DMaker(final String title, final int width, final int height) {
		setInfo(title, width, height);
		
		drawSpace = new DrawSpace(width, height);
		windowScreen = new WindowScreen(title, drawSpace);
		scenesManager = new ScenesManager(3);
	}
	
	public G2DMaker(final String title, final int width, final int height, final int maxMapsInMemory) {
		setInfo(title, width, height);
		
		drawSpace = new DrawSpace(width, height);
		windowScreen = new WindowScreen(title, drawSpace);
		scenesManager = new ScenesManager(maxMapsInMemory);
	}
	
	private void setInfo(final String title, final int width, final int height) {
		String[][] info = new String[3][2];
		info[0][0] = "window.title";
		info[0][1] = title;
		info[1][0] = "window.width";
		info[1][1] = String.valueOf(width);
		info[2][0] = "window.height";
		info[2][1] = String.valueOf(height);
 		ProyectInfo.setInfo(info);
	}
	
	public void addScene(final String name, final Scene scene) {
		scenesManager.add(name, scene);
	}
	
	public void setActualScene(final String nameScene) {
		scenesManager.setActualScene(nameScene);
	}
	
	public void addKeyBoard(final IKeyBoard keyBoard) {
		drawSpace.addKeyListener(keyBoard);
	}
	
	public void init() {
		running = true;
		loop();
	}
	
	public void loop() {
		int ups = 0;
		int fps = 0;

		final int NS_PER_SECOND = 1000000000;
		final double NS_PER_UPDATE = 16666666.6666;

		long referenceUpdate = System.nanoTime();
		long referenceCounter = System.nanoTime();

		double timeLapsed;
		double delta = 0;

		while (running) {
			final long startedLoop = System.nanoTime();

			timeLapsed = (startedLoop - referenceUpdate);
			referenceUpdate = startedLoop;

			delta += (timeLapsed / NS_PER_UPDATE);
			while (delta >= 1) {
				update();
				ups++;
				delta--;

				draw();
				fps++;
			}

			if (System.nanoTime() - referenceCounter > NS_PER_SECOND) {
				String title = ProyectInfo.get("window.title") + " | UPS:"+ups+" | FPS:"+fps;
				windowScreen.setTitle(title);
				ups = 0;
				fps = 0;
				referenceCounter = System.nanoTime();
			}

		}
	}
	
	protected void update() {
		scenesManager.update();
	}
	
	protected void draw() {
		drawSpace.draw(scenesManager);
	}
	
}

package g2dmaker.scenes;

import g2dmaker.graphics.map.LevelMap;

public abstract class Scene implements IScene {

	protected LevelMap map;
	protected String pathMap;
	protected int sidePerSprite;
	
	public Scene() {
	}
	
	public Scene(String pathMap, int sidePerSprite) {
		this.pathMap = pathMap;
		this.sidePerSprite = sidePerSprite;
	}
	
	public void clearMap() {
		map = null;
	}
	
	public void setMap() {
		this.map = new LevelMap(pathMap, sidePerSprite);
	}
	
	public LevelMap getMap() {
		return map;
	}

}

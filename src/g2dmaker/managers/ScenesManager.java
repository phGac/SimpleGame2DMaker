package g2dmaker.managers;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import g2dmaker.managers.queue.StatusQueue;
import g2dmaker.scenes.Scene;

public class ScenesManager {
	
	private static Map<String, Scene> statuses;
	private static String actualStatus;
	private static StatusQueue statusesInMemory;
	
	public ScenesManager(final int maxMapsInMemory) {
		statuses = new HashMap<String, Scene>();
		statusesInMemory = new StatusQueue(maxMapsInMemory);
	}
	
	public void add(final String nameStatus, Scene status) {
		if(! statusesInMemory.isFull()) {
			statusesInMemory.enqueue(nameStatus);
		} else {
			String name = statusesInMemory.dequeue();
			statuses.get(name).clearMap();
			statusesInMemory.enqueue(nameStatus);
		}
		statuses.put(nameStatus, status);
	}
	
	public void setActualScene(final String nameScene) {
		setActualStatusInMemory(nameScene);
		
		if(statuses.get(nameScene).getMap() == null)
			statuses.get(nameScene).setMap();
		actualStatus = nameScene;
	}

	public void update() {
		statuses.get(actualStatus).update(this);
	}

	public void draw(Graphics g) {
		statuses.get(actualStatus).draw(g);
	}
	
	private void setActualStatusInMemory(final String nameStatus) {
		if(! statusesInMemory.find(nameStatus)) {
			if(! statusesInMemory.isFull()) {
				statusesInMemory.enqueue(nameStatus);
			} else {
				String name = statusesInMemory.dequeue();
				statuses.get(name).clearMap();
				statusesInMemory.enqueue(nameStatus);
			}
		}
	}

}

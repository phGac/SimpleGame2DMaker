package samples.nibbles.entities;

import java.awt.Graphics;

import g2dmaker.entities.Entity;

public class Stadistics extends Entity {

	private int points = 0;
	private int live = 3;
	private String name = "Jack";
	
	@Override
	public void draw(Graphics g) {
		g.drawString("Live:"+live, 30, 13);
		g.drawString("Points:"+points, 100, 13);
		g.drawString("Player:"+name, 200, 13);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoint() {
		points++;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public int getLive() {
		return live;
	}
	
	public void addLive() {
		this.live++;
	}
	
	public void lessLive() {
		this.live--;
	}
	
	public boolean isDead() {
		return (live <= 0);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}

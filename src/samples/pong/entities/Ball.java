package samples.pong.entities;

import java.awt.image.BufferedImage;

import g2dmaker.entities.EntityLive;

public class Ball extends EntityLive {
	
	private int lastPositionX;
	private int lastPositionY;
	
	private int direction;
	
	private boolean moving;
	
	public Ball(int x, int y, BufferedImage sprite, boolean solid, double speed) {
		super(x, y, sprite, solid, speed);
		setCollition(1, 1, -4, -4);
	}
	
	public void move() {
		if(direction == 0) {
			int x = (int) (Math.random() * 2);
			int y = (int) (Math.random() * 2);
			if((Math.random() * 10) % 2 == 0) {
				x = -x;
			}
			if((Math.random() * 10) % 2 == 0) {
				y = -y;
			}
		} else if(direction > 0) {
			move(1, 0);
		} else {
			move(-1, 0);
		}
		
		lastPositionX = this.x;
		lastPositionY = this.y;
		
		moving = true;
		move(x, y);
	}
	
	private void calculateNewDirection() {
		if(x < lastPositionX) { //va hacia la derecha
			if(y < lastPositionY) { //va hacia abajo
				//se mueve en diagonal a la esquina superior derecha
			} else {
				//se mueve en diagonal a la esquina inferior derecha
			}
		} else { // va hacia la izquierda
			if(y < lastPositionY) {
				//se mueve en diagonal a la esquina superior izquierda
			} else {
				//se mueve en diagonal a la esquina inferior izquierda
			}
		}
		
	}
	
	public boolean isMoving() {
		return moving;
	}
	
//	public void getDirection() {
//		if(x < lastPositionX) { //va hacia la derecha
//			if(y < lastPositionY) { //va hacia abajo
//				//se mueve en diagonal a la esquina superior derecha
//			} else {
//				//se mueve en diagonal a la esquina inferior derecha
//			}
//		} else { // va hacia la izquierda
//			if(y < lastPositionY) {
//				//se mueve en diagonal a la esquina superior izquierda
//			} else {
//				//se mueve en diagonal a la esquina inferior izquierda
//			}
//		}
//	}
	
	public void flipMeaning() {
		direction = -direction;
		x = -x;
	}

}

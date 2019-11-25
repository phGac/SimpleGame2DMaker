package samples.typespeed.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import g2dmaker.managers.ScenesManager;
import g2dmaker.scenes.Scene;
import g2dmaker.tools.ProyectInfo;
import samples.typespeed.ConstantsTypeSpeed;
import samples.typespeed.entities.Teacher;

public class Board extends Scene {
	
	Teacher teacher = new Teacher();

	public Board(String pathMap, int sidePerSprite) {
		super(pathMap, sidePerSprite);
	}

	@Override
	public void update(ScenesManager manager) {
		teacher.dictate();
		teacher.move();
		teacher.removeWords();
		if(ConstantsTypeSpeed.KEYBOARD.enter) {
			teacher.qualifyWord(ConstantsTypeSpeed.KEYBOARD.text);
		}
	}

	@Override
	public void draw(Graphics g) {
		int width = ProyectInfo.getInt("window.width");
		int height = ProyectInfo.getInt("window.height");
		
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		teacher.draw(g);
		
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(ConstantsTypeSpeed.KEYBOARD.text, (int)(width*0.3), (height-30));
		
		g.setColor(Color.WHITE);
		g.drawString("Score:"+teacher.getScore(), (int)(width*0.4), 20);
	}

}

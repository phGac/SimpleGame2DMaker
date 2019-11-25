package samples.typespeed.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import g2dmaker.entities.Entity;
import g2dmaker.tools.ProyectInfo;
import g2dmaker.tools.ResourcesLoader;

public class Teacher extends Entity {

	private final String[] allWords;
	private final String[] wordsRead;
	private final ArrayList<Word> words;
	private int maxWords;
	private double generation;
	private int wordsRealPosition;
	
	private int score;
	
	public Teacher() {
		allWords = ResourcesLoader.readFileTextOnResourcesFolder("/txt/words.data").split(",");
		wordsRead = new String[allWords.length];
		wordsRealPosition = 0;
		words = new ArrayList<Word>();
		maxWords = 20;
		generation = 1;
		score = 0;
	}
	
	public void dictate() {
		int random = (int) (Math.random() * 100);
		if(words.size() <= maxWords && random%2 == 0) {
			if(random < (2+generation)) {
				int x = (int) (Math.random() * -50);
				int y = (int) (Math.random() * 300) + 20;
				words.add(new Word(x, y, null, false, 1, getWord()));
			}
		}
	}
	
	private String getWord() {
		String word = "";
		int random = (int) (Math.random() * (allWords.length -1));
//		for(int i = 0;  i < wordsRead.length; i++) {
//			
//		}
		word = allWords[random];
		
		wordsRealPosition++;
		wordsRead[wordsRealPosition] = word;
		return word;
	}
	
	public void qualifyWord(String word) {
		word = word.toLowerCase();
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i).getWord().toLowerCase().equals(word)) {
				String wrd = words.get(i).getWord();
				words.remove(i);
				score += qualify(wrd);
			}
		}
	}
	
	private int qualify(final String word) {
		if(word.length() < 5) {
			return 1;
		} else if(word.length() < 7) {
			return 3;
		} else {
			return 5;
		}
	}
	
	public void removeWords() {
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i) != null && words.get(i).getX()+10 > ProyectInfo.getInt("window.width")) {
				words.remove(i);
			}
		}
	}
	
	public void decreanceGenerattion() {
		generation -= .2;
	}
	
	public void increanceGeneration() {
		generation += .3;
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i) != null) {
				words.get(i).draw(g);
			}
		}
	}
	
	public void move() {
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i) != null) {
				words.get(i).move(1, 0);
			}
		}
	}
	
	public int getScore() {
		return score;
	}

}

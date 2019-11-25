package g2dmaker.graphics.map;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import g2dmaker.graphics.sprite.SpriteSheet;
import g2dmaker.tools.ImageEditor;
import g2dmaker.tools.ResourcesLoader;

public class LevelMap {
	
	private final int width;
	private final int height;
	
	private final BufferedImage[] sprites;
	private final boolean[] collitions;
	
	public ArrayList<Rectangle> collitionsArea = new ArrayList<Rectangle>();
	
	private final int sidePerSprite;

	public LevelMap(final String path, final int sidePerSprite) {
		this.sidePerSprite = sidePerSprite;
		
		String content = ResourcesLoader.readFileTextOnResourcesFolder(path);
		String[] parts = content.split("\\;");
		content = null;
		
		String[] dimensions = parts[0].split("x");
		
		width = Integer.parseInt(dimensions[0]);
		height = Integer.parseInt(dimensions[1]);
		
		sprites = new BufferedImage[width * height];
		collitions = new boolean[width * height];
		
		String[] vars = parts[1].split("\\,");
		String[] layers = parts[2].split("\\|");
		String[] collitions = parts[3].split("\\|");
		parts = null;
		
		extractMapInfo(vars, layers, collitions);
	}
	
	private void extractMapInfo(final String[] vars, final String[] layers, final String[] collitions) {
		Map<String, BufferedImage> variables = extractSprites(vars);
		
		final int oneLayer = (width*height)-1;
		
		int i = 0;
		for(String tile : layers) {
			if(i > oneLayer) {
				BufferedImage aux = variables.get(tile);
				if(aux != null)
					sprites[i - oneLayer] = aux;
			} else {
				sprites[i] = variables.get(tile);
			}
			
			String collition = collitions[i];
			switch(collition) {
			case "00":
			case "000":
				this.collitions[i] = false;
				break;
			case "01":
			case "001":
				this.collitions[i] = true;
				
				int positionY = (int) (i / width) * sidePerSprite;
				int positionX = (i % width) * sidePerSprite;
				
				Rectangle r = new Rectangle(positionX, positionY, sprites[i].getWidth(), sprites[i].getHeight());
				collitionsArea.add(r);
				break;
			}
			i++;
		}
		
	}
	
	private Map<String, BufferedImage> extractSprites(String[] parts) {
		Map<String, BufferedImage> variables = new HashMap<String, BufferedImage>();
		
		SpriteSheet sheet = null;
		String sheetName = "";
		for(String part : parts) {
			String[] var = part.split("=");
			String[] varInfo = var[1].split("\\~");
			if(varInfo[0].startsWith("#")) {
				int color = Integer.parseInt(varInfo[0].replace("#", ""), 32);
				BufferedImage sprite = new BufferedImage(sidePerSprite, sidePerSprite, BufferedImage.TYPE_INT_RGB);
				int y = 0;
				int x = 0;
				for(int i = 0; i < (sidePerSprite*sidePerSprite); i++) {
					if(x >= sidePerSprite)
						x = 0;
					if(y >= sidePerSprite)
						y = 0;
					
					sprite.setRGB(x, y, color);
					y++;
					x++;
				}
				variables.put(var[0], sprite);
				continue;
			}
			else if(! sheetName.equals(varInfo[0])) {
				String path = "/images/textures/" + varInfo[0] + ".png";
				sheet = new SpriteSheet(path, sidePerSprite);
			}
			
			int x = Integer.parseInt(varInfo[1]);
			int y = Integer.parseInt(varInfo[2]);
			BufferedImage sprite = sheet.getSprite(x, y);
			if(varInfo.length > 3) {
				int toRotate = Integer.parseInt(varInfo[3]);
				sprite = ImageEditor.rotate(sprite, toRotate);
			}
			variables.put(var[0], sprite);
		}
		
		return variables;
	}
	
	public void draw(Graphics g ) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				BufferedImage image = getSprite(x, y);
				int posX = x * sidePerSprite;
				int posY = y * sidePerSprite;
				g.drawImage(image, posX, posY, null);
			}
		}
	}
	
	public void drawCollitionsArea(Graphics g) {
		for (int i = 0; i < collitionsArea.size(); i++) {
			final Rectangle r = collitionsArea.get(i);
			g.drawRect(r.x, r.y, r.width, r.height);
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getSidePerSprite() {
		return sidePerSprite;
	}
	
	public int getWidthPixels() {
		return (width * sidePerSprite);
	}
	
	public int getHeightPixels() {
		return (height * sidePerSprite);
	}
	
	public BufferedImage getSprite(int x, int y) {
		return sprites[x + y * width];
	}

}

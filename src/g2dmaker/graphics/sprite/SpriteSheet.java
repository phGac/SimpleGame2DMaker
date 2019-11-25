package g2dmaker.graphics.sprite;

import java.awt.image.BufferedImage;

import g2dmaker.tools.ResourcesLoader;

public class SpriteSheet {
	
	private final int width;
	private final int height;
	
	private final BufferedImage[] sprites;
	private final int widthPerSprite;
	private final int heightPerSprite;

	public SpriteSheet(final String path, final int sidePerSprite) {
		this.widthPerSprite = sidePerSprite;
		this.heightPerSprite = sidePerSprite;
		
		BufferedImage image;
		try {
			image = ResourcesLoader.loadCompatibleImageTransparency(path);
		}catch(Exception e) {
			image = ResourcesLoader.loadCompatibleImageOpaque(path);
		}
		width = image.getWidth();
		height = image.getHeight();
		
		int countWidth = getCountWidth();
		int countHeight = getCountHeight();
		sprites = new BufferedImage[countWidth * countHeight];
		
		extractSprites(image, countWidth, countHeight);
	}
	
	public SpriteSheet(final String path, final int widthPerSprite, final int heightPerSprite) {
		this.widthPerSprite = widthPerSprite;
		this.heightPerSprite = heightPerSprite;
		
		BufferedImage image;
		try {
			image = ResourcesLoader.loadCompatibleImageTransparency(path);
		}catch(Exception e) {
			image = ResourcesLoader.loadCompatibleImageOpaque(path);
		}
		width = image.getWidth();
		height = image.getHeight();
		
		int countWidth = getCountWidth();
		int countHeight = getCountHeight();
		sprites = new BufferedImage[countWidth * countHeight];
		
		extractSprites(image, countWidth, countHeight);
	}
	
	private void extractSprites(final BufferedImage image, final int countWidth, final int countHeight) {
		for (int y = 0; y < countHeight; y++) {
			for (int x = 0; x < countWidth; x++) {
				final int positionX = x * widthPerSprite;
				final int positionY = y * heightPerSprite;
				
				sprites[x + y * countWidth] = image.getSubimage(positionX, positionY, widthPerSprite, heightPerSprite);
			}
		}
	}
	
	public int getCountWidth() {
		return (width / widthPerSprite);
	}
	
	public int getCountHeight() {
		return (height / heightPerSprite);
	}
	
	public BufferedImage getSprite(final int index) {
		return sprites[index];
	}

	public BufferedImage getSprite(final int x, final int y) {
		int count = getCountWidth();
		return sprites[x + y * count];
	}
	
}

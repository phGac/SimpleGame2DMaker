package g2dmaker.tools;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public final class ResourcesLoader {

	public static BufferedImage loadCompatibleImageOpaque(final String path) {
		Image image = null;
		try {
			image = ImageIO.read(ClassLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		BufferedImage acceleratedImage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null),
				Transparency.OPAQUE);

		Graphics g = acceleratedImage.getGraphics();

		g.drawImage(image, 0, 0, null);
		g.dispose();

		return acceleratedImage;
	}

	public static BufferedImage loadCompatibleImageTransparency(final String path) {
		Image image = null;
		try {
			image = ImageIO.read(ClassLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		BufferedImage acceleratedImage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null),
				Transparency.TRANSLUCENT);

		Graphics g = acceleratedImage.getGraphics();

		g.drawImage(image, 0, 0, null);
		g.dispose();

		return acceleratedImage;
	}

	public static String readFileTextOnResourcesFolder(final String path) {
		String content = "";

		InputStream inputBytes = ClassLoader.class.getResourceAsStream(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputBytes));

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputBytes != null) {
					inputBytes.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return content;
	}
	
	public static String readFileText(final String path) {
		String content = "";

		InputStream inputBytes = null;
		BufferedReader reader = null;
		try {
			inputBytes = new FileInputStream(path);
			reader = new BufferedReader(new InputStreamReader(inputBytes));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputBytes != null) {
					inputBytes.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return content;
	}
	
}

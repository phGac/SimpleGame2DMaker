package g2dmaker.tools;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;

public final class ImageEditor {

	public static BufferedImage rotate(BufferedImage image, final int gradesToRotate) {
		final double grades = Math.toRadians (gradesToRotate);
		AffineTransform at = AffineTransform.getRotateInstance(grades, image.getWidth()*0.5, image.getHeight()*0.5);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		image = op.filter(image, null);
		return image;
	}
	
	public static BufferedImage flip(BufferedImage image) {
		AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
        return createTransformed(image, at);
	}
	
	public static BufferedImage invert(BufferedImage image) {
		if (image.getType() != BufferedImage.TYPE_INT_ARGB){
	        image = convertToARGB(image);
	    }
        LookupTable lookup = new LookupTable(0, 4){
            @Override
            public int[] lookupPixel(int[] src, int[] dest){
                dest[0] = (int)(255-src[0]);
                dest[1] = (int)(255-src[1]);
                dest[2] = (int)(255-src[2]);
                return dest;
            }
        };
        LookupOp op = new LookupOp(lookup, new RenderingHints(null));
        return op.filter(image, null);
	}
	
	private static BufferedImage createTransformed(BufferedImage image, AffineTransform at){
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.transform(at);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
	}
	
	private static BufferedImage convertToARGB(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    } 
	
}

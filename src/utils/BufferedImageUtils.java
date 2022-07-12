package utils;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageUtils {

    public static BufferedImage loadImage(final String path) {
        BufferedImage image;
        try {
            File file = new File(path);
            image = ImageIO.read(file);
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
        return image;
    }

    public static BufferedImage scaleImage(final BufferedImage image, final double scale) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage after = new BufferedImage((int) (w * scale), (int) (h * scale), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return scaleOp.filter(image, after);
    }

    public static int getScaled(final double toScale, final double scale) {
        return (int) Math.floor(toScale * scale);
    }
}

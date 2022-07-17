package utils;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageUtils {	// fuer performance, da die Bilder im Hintergrund geladen werden und skaliert werden

	/*Konstruktor fuers Laden der Bilder aus Pfad*/
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

    public static int getScaled(final double toScale, final double scale) {
        return (int) Math.floor(toScale * scale);
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pixelator {


    private static int PIX_SIZE = 37;


    /**
     * Quelle: https://stackoverflow.com/questions/15777821/how-can-i-pixelate-a-jpg-with-java
     * @return
     */
    public static BufferedImage pixelate(BufferedImage imageToPixelate) {

        BufferedImage pixelateImage = new BufferedImage(108, 80,
                imageToPixelate.getType());
        int x = 0;
        int y = 0;
        for (int y2 = 0; y2 < imageToPixelate.getHeight(); y2 += PIX_SIZE) {
            x=0;
            for (int x2 = 0; x2 < imageToPixelate.getWidth(); x2 += PIX_SIZE) {
                BufferedImage croppedImage = getCroppedImage(imageToPixelate, x2, y2, PIX_SIZE, PIX_SIZE);
                Color dominantColor = getDominantColor(croppedImage);
                if(x < 108 && y < 80){
                    pixelateImage.setRGB(x,y, dominantColor.getRGB());
                }
                x++;
            }
            y++;
        }
        return pixelateImage;
    }

    public static BufferedImage getCroppedImage(BufferedImage image, int startx, int starty, int width, int height) {
        if (startx < 0) startx = 0;
        if (starty < 0) starty = 0;
        if (startx > image.getWidth()) startx = image.getWidth();
        if (starty > image.getHeight()) starty = image.getHeight();
        if (startx + width > image.getWidth()) width = image.getWidth() - startx;
        if (starty + height > image.getHeight()) height = image.getHeight() - starty;
        return image.getSubimage(startx, starty, width, height);
    }

    public static Color getDominantColor(BufferedImage image) {
        int sumR = 0, sumB = 0, sumG = 0, sum2 = 0;
        int color = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                color = image.getRGB(x, y);
                Color c = new Color(color);
                sumR += c.getRed();
                sumB += c.getBlue();
                sumG += c.getGreen();
                sum2++;
            }
        }
        return new Color(sumR / sum2, sumG / sum2, sumB / sum2);
    }
}

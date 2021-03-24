import java.awt.image.*;
import java.awt.*;
import javax.swing.*;

public class JImageDisplay extends JComponent {
    public BufferedImage bufferedImage;
    public JImageDisplay(int width, int height) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    }

    public void clearImage() {
        for (int x = 0; x < bufferedImage.getHeight(); x++) {
            for (int y = 0; y < bufferedImage.getWidth(); y++) {
                bufferedImage.setRGB(x, y, 0);
            }
        }
    }

    public  void drawPixel(int x, int y, int rgbColor) {
        bufferedImage.setRGB(x, y, rgbColor);
    }
}
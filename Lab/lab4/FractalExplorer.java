import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FractalExplorer {
    private int displaySize;
    private JImageDisplay imageDisplay;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    public FractalExplorer(int dSize) {
        displaySize = dSize;
        range = new Rectangle2D.Double();
        fractalGenerator = new Mandelbrot();
        fractalGenerator.getInitialRange(range);
        imageDisplay = new JImageDisplay(dSize, dSize);
    }
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal");
        frame.add(imageDisplay, BorderLayout.CENTER);
        JButton resetButton = new JButton("Reset");
        ResetButton reset = new ResetButton();
        resetButton.addActionListener(reset);
        frame.add(resetButton, BorderLayout.SOUTH);
        MouseClickZoom mouseClick = new MouseClickZoom();
        frame.addMouseListener(mouseClick);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private void drawFractal() {
        float hue;
        int countIterations;
        double xCoord, yCoord;
        for (int x = 0; x < displaySize; x++) {
            for (int y = 0; y < displaySize; y++) {
                xCoord = fractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                yCoord = fractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                countIterations = fractalGenerator.numIterations(xCoord, yCoord);
                if (countIterations == -1) {
                    imageDisplay.drawPixel(x, y, 0);
                }
                else {
                    hue = 0.7f + (float) countIterations / 200f;
                    imageDisplay.drawPixel(x, y, Color.HSBtoRGB(hue, 1f, 1f));
                }
            }
        }
        imageDisplay.repaint();
    }
    private class ResetButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }
    private class MouseClickZoom extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            int x = event.getX();
            int y = event.getY();
            double xCoord = fractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
            double yCoord = fractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }
    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }
}

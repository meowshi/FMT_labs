import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.JFileChooser.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;

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
        ButtonHandler reset = new ButtonHandler();
        resetButton.addActionListener(reset);
        
        JButton saveButton = new JButton("Save");
        ButtonHandler save = new ButtonHandler();
        saveButton.addActionListener(save);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(resetButton);
        buttonsPanel.add(saveButton);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        ButtonHandler comboBoxChoice = new ButtonHandler();
        comboBox.addActionListener(comboBoxChoice);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Fractal"));
        panel.add(comboBox);
        frame.add(panel, BorderLayout.NORTH);
        
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
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() instanceof JComboBox) {
                JComboBox source = (JComboBox)event.getSource(); 
                fractalGenerator =  (FractalGenerator)source.getSelectedItem();
                fractalGenerator.getInitialRange(range);
                drawFractal();
            }
            if (event.getActionCommand().equals("Reset")) {
                fractalGenerator.getInitialRange(range);
                drawFractal();
            }
            if (event.getActionCommand().equals("Save")) {
                JFileChooser chooser = new JFileChooser();
                javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showSaveDialog(imageDisplay) == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = chooser.getSelectedFile();
                    try {
                        ImageIO.write(imageDisplay.bufferedImage, "png", file);
                    }
                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(imageDisplay, "Error", "Cannot save image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
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

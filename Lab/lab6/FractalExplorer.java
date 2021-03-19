import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.JFileChooser.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import javax.sql.RowSet;

public class FractalExplorer {
    private int displaySize;
    private JImageDisplay imageDisplay;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;
    private int rowsRemainig;
    private JButton resetButton = new JButton("Reset");
    private JButton saveButton = new JButton("Save");
    private JComboBox comboBox = new JComboBox();


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
        
        ButtonHandler reset = new ButtonHandler();
        resetButton.addActionListener(reset);
        
        ButtonHandler save = new ButtonHandler();
        saveButton.addActionListener(save);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(resetButton);
        buttonsPanel.add(saveButton);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

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
        enableUI(false);
        rowsRemainig = displaySize;
        for (int y = 0; y < displaySize; y++) {
            FractalWorker fractalWorker = new FractalWorker(y);
            fractalWorker.execute();
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
            if (rowsRemainig == 0) {
                int x = event.getX();
                int y = event.getY();
                double xCoord = fractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                double yCoord = fractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                drawFractal();
            }
        }
    }
    private class FractalWorker extends SwingWorker<Object, Object> {
        private int yC;
        private int xColor[];
        public FractalWorker(int y) {
            yC = y;
        }
        public Object doInBackground() {
            float hue;
            int countIterations;
            double xCoord, yCoord;
            xColor = new int[displaySize];
            for (int x = 0; x < displaySize; x++) {
                xCoord = fractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                yCoord = fractalGenerator.getCoord(range.y, range.y + range.height, displaySize, yC);
                countIterations = fractalGenerator.numIterations(xCoord, yCoord);
                if (countIterations == -1) {
                    xColor[x] = 0;
                }
                else {
                    hue = 0.7f + (float) countIterations / 200f;
                    xColor[x] = Color.HSBtoRGB(hue, 1f, 1f);
                }
            }
            return null;
        }
        public void done() {
            for (int x = 0; x < xColor.length; x++) {
                imageDisplay.drawPixel(x, yC, xColor[x]);
            }
            imageDisplay.repaint(0, 0, yC, displaySize, 1);
            rowsRemainig--;
            if (rowsRemainig == 0) {
                enableUI(true);
            }
        }
    }
    public void enableUI(boolean enable) {
        resetButton.setEnabled(enable);
        saveButton.setEnabled(enable);
        comboBox.setEnabled(enable);
    }
    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }
}

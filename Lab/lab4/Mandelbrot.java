import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = range.height = 3;
    }

    public int numIterations(double x, double y) {
        int countIterations = 0;
        double zReal = 0;
        double zImaginary = 0;
        double zRealNew, zImaginaryNew;
        while (countIterations < MAX_ITERATIONS && zReal * zReal + zImaginary * zImaginary < 4) {
            zRealNew = zReal * zReal - zImaginary * zImaginary + x;
            zImaginaryNew = 2 * zReal * zImaginary + y;
            zReal = zRealNew;
            zImaginary = zImaginaryNew;
            countIterations++;
        }
        if (countIterations == MAX_ITERATIONS) return -1;
        return countIterations;
    }
}

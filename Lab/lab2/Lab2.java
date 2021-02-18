import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coords of the first point: ");
        Point3d point1 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Enter coords of the second point: ");
        Point3d point2 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Enter coords of the third point: ");
        Point3d point3 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        sc.close();
        if (!point1.compare(point2) && !point1.compare(point3) && !point2.compare(point3)){
            System.out.println("Area of triangle = " + String.format("%.2f",computeArea(point1, point2, point3)));
        }
        else{
            System.out.println("Error! Wrong input!");
        }
    }
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point3.distanceTo(point1);
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

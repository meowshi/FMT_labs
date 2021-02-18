import java.util.Scanner;
// Класс второй лабораторной работы
public class Lab2 {
    public static void main(String[] args) {
        // инициализация сканера
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coords of the first point: ");
        // Создание первой точки. Ввод координат
        Point3d point1 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Enter coords of the second point: ");
        // Создание второй точки. Ввод координат
        Point3d point2 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Enter coords of the third point: ");
        // Создание третьей точки. Ввод координат
        Point3d point3 = new Point3d(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        sc.close();
        // Проверка на то, не ввел ли пользователь одинаковые точки
        if (!point1.compare(point2) && !point1.compare(point3) && !point2.compare(point3)){
            // Подсчет площади и вывод результата
            System.out.println("Area of triangle = " + String.format("%.2f",computeArea(point1, point2, point3)));
        }
        else{
            // Сообщение об ошибочном вводе
            System.out.println("Error! Wrong input!");
        }
    }
    // Расчет площади треугольника по трем точкам
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        // Расчет первой стороны
        double a = point1.distanceTo(point2);
        // Расчет второй стороны
        double b = point2.distanceTo(point3);
        // Расчет третьей стороны
        double c = point3.distanceTo(point1);
        // Расчет полупериметра
        double p = 0.5 * (a + b + c);
        // Возврат площади треугольника
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
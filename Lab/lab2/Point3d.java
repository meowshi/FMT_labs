// Класс трехмерной точки
public class Point3d extends Point2d {
    // Координата Z
    private double zCoord;
    // Конструктор инициализации
    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }
    // Конструктор по умолчанию
    public Point3d(){
        this(0.0, 0.0, 0.0);
    }
    // Возвращение координаты Z
    public double getZ(){
        return zCoord;
    }
    // Установка значения координаты Z
    public void setZ(double val){
        zCoord = val;
    }
    // Сравнение значений координат точек
    // true – соответствующие координаты двух точек совпали
    // false - в противном случае
    public boolean compare(Point3d p){
        if (this.getX() == p.getX() && this.getY() == p.getY() && this.zCoord == p.zCoord){
            return true;
        }
        return false;
    }
    // Возвращает расстояние от точки до точки
    public double distanceTo(Point3d p){
        return Math.sqrt(Math.pow(this.getX() - p.getX(), 2) + Math.pow(this.getY() - p.getY(), 2) + Math.pow(this.zCoord - p.zCoord, 2));
    }
}
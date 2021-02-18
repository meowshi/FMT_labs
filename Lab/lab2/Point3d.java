// Класс трехмерной точки
public class Point3d {
    // Координата X
    private double xCoord;
    // Координата Y
    private double yCoord;
    // Координата Z
    private double zCoord;
    // Конструктор инициализации
    public Point3d(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    // Конструктор по умолчанию
    public Point3d(){
        this(0.0, 0.0, 0.0);
    }
    // Возвращение координаты X
    public double getX(){
        return xCoord;
    }
    // Возвращение координаты Y
    public double getY(){
        return yCoord;
    }
    // Возвращение координаты Z
    public double getZ(){
        return zCoord;
    }
    // Установка значения координаты X
    public void setX(double val){
        xCoord = val;
    }
    // Установка значения координаты Y
    public void setY(double val){
        yCoord = val;
    }
    // Установка значения координаты Z
    public void setZ(double val){
        zCoord = val;
    }
    // Сравнение значений координат точек
    // true – соответствующие координаты двух точек совпали
    // false - в противном случае
    public boolean compare(Point3d p){
        if (this.xCoord == p.xCoord && this.yCoord == p.yCoord && this.zCoord == p.zCoord){
            return true;
        }
        return false;
    }
    // Возвращает расстояния от точки до точки
    public double distanceTo(Point3d p){
        return Math.sqrt(Math.pow(this.xCoord - p.xCoord, 2) + Math.pow(this.yCoord - p.yCoord, 2) + Math.pow(this.zCoord - p.zCoord, 2));
    }
}
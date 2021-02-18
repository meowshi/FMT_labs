public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;
    public Point3d(double x, double y, double z){
        // Попробовать this(x, y, z);
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    public Point3d(){
        this(0.0, 0.0, 0.0);
    }
    public double getX(){
        return xCoord;
    }
    public double getY(){
        return yCoord;
    }
    public double getZ(){
        return zCoord;
    }
    public void setX(double val){
        xCoord = val;
    }
    public void setY(double val){
        yCoord = val;
    }
    public void setZ(double val){
        zCoord = val;
    }
    public boolean compare(Point3d p){
        if (this.xCoord == p.xCoord && this.yCoord == p.yCoord && this.zCoord == p.zCoord){
            return true;
        }
        return false;
    }
    public double distanceTo(Point3d p){
        return Math.sqrt(Math.pow(this.xCoord - p.xCoord, 2) + Math.pow(this.yCoord - p.yCoord, 2) + Math.pow(this.zCoord - p.zCoord, 2));
    }
}

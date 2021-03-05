/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    public boolean equals(Object obj) {
        Location loc = (Location)obj;
        if (this.xCoord == loc.xCoord && this.yCoord == loc.yCoord) return true;
        return false;
    }

    public int hashCode() {
        int result = Integer.hashCode(this.xCoord);
        result = 31 * result + Integer.hashCode(this.yCoord);
        return result;
    }
}
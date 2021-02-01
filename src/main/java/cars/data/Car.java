package cars.data;

public abstract class Car {
    
    public String id;

    public double dirX;
    public double dirY;
    public double lat;
    public double lon;

    public abstract void setPos(double lat, double lon);    
    
}

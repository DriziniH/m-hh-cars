package cars.data;

import java.util.List;

public abstract class Car {

    public String id;

    public double dirX;
    public double dirY;
    public double lat;
    public double lon;

    public String model;
    public List<String> labels;
    public String fuel;

    public double estimatedRange;
    public double travelTimeTotal;
    public double travelTime;

    public double oilLevel;
    public double breakFluidLevel;
    public double fuelLevel;

    public boolean engineWarning;
    public boolean breaksWarning;
    public boolean forwardCollisionWarning;
    public boolean airbag;
    public boolean serviceCall;
    public double tirePressure;
    public boolean lightingSystemFailure;

    public double temperatureEngine;
    public double temperatureInside;
    public double temperatureOutside;
    public double temperatureBreaks;
    public double temperatureTires;

    public double breakPower;
    public boolean breakActive;

    public double gasPower;
    public boolean gasActive;
    public boolean light;
    public boolean acc;

    public double rpm;
    public double oxygenLevel;

    public boolean infotainmentOn;
    public String infotainmentService;
    public double infotainmentVolume;

    public boolean geoChip;

    public double breaksHealth;
    public double engineHealth;
    public double tireHealth;
    public double mufflerHealth;
    public double gearsHealth;
    public double batteryHealth;

    public boolean rapidSteeringWheelMovement;
    public boolean drugged;
    public boolean drivingOnMarkers;

    public abstract void setPos(double lat, double lon);

}

package cars.data;

import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class CarUSA extends Car implements Serializable {
    /**
     * Data class for usa car data
     */

    private static final long serialVersionUID = -5327689289732554907L;

    public String model;
    public List<String> labels;
    public String fuel;

    public double mileageTotal;
    public double mileageStart;
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
    public double mph;
    public double rpm;
    public double oxygenLevel;

    public boolean infotainmentOn;
    public String infotainmentService;
    public double infotainmentVolume;

    public CarUSA(String id, String model, List<String> labels, String fuel) {
        this.id = id;
        this.model = model;
        this.labels = labels;
        this.fuel = fuel;

        // Initialze car direction
        Random rand = new Random();
        super.dirX = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);
        super.dirY = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);

        super.lat = rand.nextInt(7) + 38 + rand.nextDouble();
        super.lon = rand.nextInt(45) - 123 + rand.nextDouble();
    };

    @Override
    public void setPos(double lat, double lon) {
        super.lat = lat;
        super.lon = lon;
    }

    public void setValues(double mileageTotal, double mileageStart, double estimatedRange, double travelTimeTotal,
            double travelTime, double oilLevel, double breakFluidLevel, double fuelLevel, boolean engineWarning,
            boolean breaksWarning, boolean forwardCollisionWarning, boolean airbag, boolean serviceCall,
            double tirePressure, boolean lightingSystemFailure, double temperatureEngine, double temperatureInside,
            double temperatureOutside, double temperatureBreaks, double temperatureTires, double breakPower,
            boolean breakActive, double gasPower, boolean gasActive, boolean light, boolean acc, double mph, double rpm,
            double oxygenLevel, boolean infotainmentOn, String infotainmentService, double infotainmentVolume) {

        this.mileageTotal = mileageTotal;
        this.mileageStart = mileageStart;
        this.estimatedRange = estimatedRange;
        this.travelTimeTotal = travelTimeTotal;
        this.travelTime = travelTime;
        this.oilLevel = oilLevel;
        this.breakFluidLevel = breakFluidLevel;
        this.fuelLevel = fuelLevel;
        this.engineWarning = engineWarning;
        this.breaksWarning = breaksWarning;
        this.forwardCollisionWarning = forwardCollisionWarning;
        this.airbag = airbag;
        this.serviceCall = serviceCall;
        this.tirePressure = tirePressure;
        this.lightingSystemFailure = lightingSystemFailure;
        this.temperatureEngine = temperatureEngine;
        this.temperatureInside = temperatureInside;
        this.temperatureOutside = temperatureOutside;
        this.temperatureBreaks = temperatureBreaks;
        this.temperatureTires = temperatureTires;
        this.breakPower = breakPower;
        this.breakActive = breakActive;
        this.gasPower = gasPower;
        this.gasActive = gasActive;
        this.light = light;
        this.acc = acc;
        this.mph = mph;
        this.rpm = rpm;
        this.oxygenLevel = oxygenLevel;
        super.lat = lat;
        super.lon = lon;
        this.infotainmentOn = infotainmentOn;
        this.infotainmentService = infotainmentService;
        this.infotainmentVolume = infotainmentVolume;
    }
}
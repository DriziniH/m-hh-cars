package cars.data;

import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class CarUSA extends Car implements Serializable {

    private static final long serialVersionUID = -5327689289732554907L;

    public double mileageTotal;
    public double mileageStart;
    public double mph;
    public double consumptionMile;
    public double co2Mile;

    public CarUSA(String id, String model, List<String> labels, String fuel) {
        this.id = id;
        this.model = model;
        this.labels = labels;
        this.fuel = fuel;

        // Initialze car direction
        Random rand = new Random();
        this.dirX = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);
        this.dirY = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);

        this.lat = rand.nextInt(7) + 38 + rand.nextDouble();
        this.lon = rand.nextInt(45) - 123 + rand.nextDouble();

        this.drugged = rand.nextBoolean();
        this.breaksHealth = rand.nextInt(100) + rand.nextDouble();
        this.engineHealth = rand.nextInt(100) + rand.nextDouble();
        this.tireHealth = rand.nextInt(100) + rand.nextDouble();
        this.mufflerHealth = rand.nextInt(100) + rand.nextDouble();
        this.gearsHealth = rand.nextInt(100) + rand.nextDouble();
        this.batteryHealth = rand.nextInt(100) + rand.nextDouble();
        this.geoChip = rand.nextBoolean();
    };

    @Override
    public void setPos(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public void setValues(double mileageTotal, double mileageStart, double estimatedRange, double travelTimeTotal,
            double travelTime, double oilLevel, double breakFluidLevel, double fuelLevel, boolean engineWarning,
            boolean breaksWarning, boolean forwardCollisionWarning, boolean airbag, boolean serviceCall,
            double tirePressure, boolean lightingSystemFailure, double temperatureEngine, double temperatureInside,
            double temperatureOutside, double temperatureBreaks, double temperatureTires, double breakPower,
            boolean breakActive, double gasPower, boolean gasActive, boolean light, boolean acc, double mph, double rpm,
            double oxygenLevel, boolean infotainmentOn, String infotainmentService, double infotainmentVolume,
            double consumptionMile, double co2Mile, boolean rapidSteeringWheelMovement,
            boolean drivingOnMarkers) {

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
        this.infotainmentOn = infotainmentOn;
        this.infotainmentService = infotainmentService;
        this.infotainmentVolume = infotainmentVolume;
        this.consumptionMile = consumptionMile;
        this.co2Mile = co2Mile;
        this.rapidSteeringWheelMovement = rapidSteeringWheelMovement;
        this.drivingOnMarkers = drivingOnMarkers;
    }
}
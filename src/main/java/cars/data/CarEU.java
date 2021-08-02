package cars.data;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class CarEU extends Car implements Serializable {
    /**
     * Data class for eu car data
     */

    private static final long serialVersionUID = -3145577002152184851L;

    public double kilometerTotal;
    public double kilometerStart;
    public double kmh;
    public double consumptionKm;
    public double co2Km;

    public CarEU(String id, String model, List<String> labels, String fuel) {
        this.id = id;
        this.model = model;
        this.labels = labels;
        this.fuel = fuel;

        // Initialize car direction
        Random rand = new Random();
        this.dirX = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);
        this.dirY = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);

        this.lat = rand.nextInt(10) + 44 + rand.nextDouble();
        this.lon = rand.nextInt(32) - 2 + rand.nextDouble();

        this.drugged = rand.nextBoolean();
        this.breaksHealth = rand.nextInt(90) + 10 + rand.nextDouble();
        this.engineHealth = rand.nextInt(90)+ 10 + rand.nextDouble();
        this.tireHealth = rand.nextInt(90)+ 10 + rand.nextDouble();
        this.mufflerHealth = rand.nextInt(90)+ 10 + rand.nextDouble();
        this.gearsHealth = rand.nextInt(90)+ 10 + rand.nextDouble();
        this.batteryHealth = rand.nextInt(90)+ 10 + rand.nextDouble();
        this.geoChip = true; rand.nextBoolean(); 
    };

    public void setValues(double kilometerTotal, double kilometerStart, double estimatedRange, double travelTimeTotal,
            double travelTime, double oilLevel, double breakFluidLevel, double fuelLevel, boolean engineWarning,
            boolean breaksWarning, boolean forwardCollisionWarning, boolean airbag, boolean serviceCall,
            double tirePressure, boolean lightingSystemFailure, double temperatureEngine, double temperatureInside,
            double temperatureOutside, double temperatureBreaks, double temperatureTires, double breakPower,
            boolean breakActive, double gasPower, boolean gasActive, boolean light, boolean acc, double kmh, double rpm,
            double oxygenLevel, boolean infotainmentOn, String infotainmentService, double infotainmentVolume,
            double consumptionKm, double co2Km, boolean rapidSteeringWheelMovement,
            boolean drivingOnMarkers) {

        this.kilometerTotal = kilometerTotal;
        this.kilometerStart = kilometerStart;
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
        this.kmh = kmh;
        this.rpm = rpm;
        this.oxygenLevel = oxygenLevel;
        this.infotainmentOn = infotainmentOn;
        this.infotainmentService = infotainmentService;
        this.infotainmentVolume = infotainmentVolume;
        this.consumptionKm = consumptionKm;
        this.co2Km = co2Km;
        this.rapidSteeringWheelMovement = rapidSteeringWheelMovement;
        this.drivingOnMarkers = drivingOnMarkers;
    }

    @Override
    public void setPos(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
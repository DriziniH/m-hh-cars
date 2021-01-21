package cars.data;

import java.io.Serializable;
import java.util.List;

public class CarEU implements Serializable {
    /**
     * Data class for eu car data
     */

    private String id;

    private String model;
    private List<String> labels;
    private String fuel;

    private double kilometerTotal;
    private double kilometerStart;
    private double estimatedRange;
    private double travelTimeTotal;
    private double travelTime;

    private double oilLevel;
    private double breakFluidLevel;
    private double fuelLevel;

    private boolean engineWarning;
    private boolean breaksWarning;
    private boolean forwardCollisionWarning;
    private boolean airbag;
    private boolean serviceCall;
    private double tirePressure;
    private boolean lightingSystemFailure;

    private double temperatureEngine;
    private double temperatureInside;
    private double temperatureOutside;
    private double temperatureBreaks;
    private double temperatureTires;

    private double breakPower;
    private boolean breakActive;

    private double gasPower;
    private boolean gasActive;
    private boolean light;
    private boolean acc;
    private double kmh;
    private double rpm;
    private double oxygenLevel;
    private double lat;
    private double lon;

    private boolean infotainmentOn;
    private String infotainmentService;
    private double infotainmentVolume;

    public CarEU(String id, String model, List<String> labels, String fuel, double kilometerTotal,
            double kilometerStart, double estimatedRange, double travelTimeTotal, double travelTime, double oilLevel,
            double breakFluidLevel, double fuelLevel, boolean engineWarning, boolean breaksWarning,
            boolean forwardCollisionWarning, boolean airbag, boolean serviceCall, double tirePressure,
            boolean lightingSystemFailure, double temperatureEngine, double temperatureInside,
            double temperatureOutside, double temperatureBreaks, double temperatureTires, double breakPower,
            boolean breakActive, double gasPower, boolean gasActive, boolean light, boolean acc, double kmh, double rpm,
            double oxygenLevel, double lat, double lon, boolean infotainmentOn, String infotainmentService,
            double infotainmentVolume) {
        super();
        this.id = id;
        this.model = model;
        this.labels = labels;
        this.fuel = fuel;
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
        this.lat = lat;
        this.lon = lon;
        this.infotainmentOn = infotainmentOn;
        this.infotainmentService = infotainmentService;
        this.infotainmentVolume = infotainmentVolume;
    }

}

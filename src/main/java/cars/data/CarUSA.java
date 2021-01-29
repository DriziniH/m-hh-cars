package cars.data;

import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class CarUSA implements Serializable {
    /**
     * Data class for usa car data
     */

    private static final long serialVersionUID = -5327689289732554907L;

    private String id;

    private String model;
    private List<String> labels;
    private String fuel;

    private double mileageTotal;
    private double mileageStart;
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
    private double mph;
    private double rpm;
    private double oxygenLevel;
    private double lat;
    private double lon;

    private boolean infotainmentOn;
    private String infotainmentService;
    private double infotainmentVolume;

    private double dirx;
    private double diry;

    public CarUSA(String id, String model, List<String> labels, String fuel) {
        this.id = id;
        this.model = model;
        this.labels = labels;
        this.fuel = fuel;

        // Initialze car direction
        Random rand = new Random();
        this.dirx = rand.nextDouble() *  (rand.nextBoolean() ? -1 : 1);
        this.diry = rand.nextDouble() *  (rand.nextBoolean() ? -1 : 1);

        this.lat = rand.nextInt(7) + 38 + rand.nextDouble();
        this.lon = rand.nextInt(45) - 123 + rand.nextDouble();
    };

    public void setPos(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    public void setValues(double mileageTotal, double mileageStart, double estimatedRange, double travelTimeTotal,
            double travelTime, double oilLevel, double breakFluidLevel, double fuelLevel, boolean engineWarning,
            boolean breaksWarning, boolean forwardCollisionWarning, boolean airbag, boolean serviceCall,
            double tirePressure, boolean lightingSystemFailure, double temperatureEngine, double temperatureInside,
            double temperatureOutside, double temperatureBreaks, double temperatureTires, double breakPower,
            boolean breakActive, double gasPower, boolean gasActive, boolean light, boolean acc, double mph, double rpm,
            double oxygenLevel, boolean infotainmentOn, String infotainmentService,
            double infotainmentVolume) {

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
        this.lat = lat;
        this.lon = lon;
        this.infotainmentOn = infotainmentOn;
        this.infotainmentService = infotainmentService;
        this.infotainmentVolume = infotainmentVolume;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getFuel() {
        return this.fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getMileageTotal() {
        return this.mileageTotal;
    }

    public void setMileageTotal(double mileageTotal) {
        this.mileageTotal = mileageTotal;
    }

    public double getMileageStart() {
        return this.mileageStart;
    }

    public void setMileageStart(double mileageStart) {
        this.mileageStart = mileageStart;
    }

    public double getEstimatedRange() {
        return this.estimatedRange;
    }

    public void setEstimatedRange(double estimatedRange) {
        this.estimatedRange = estimatedRange;
    }

    public double getTravelTimeTotal() {
        return this.travelTimeTotal;
    }

    public void setTravelTimeTotal(double travelTimeTotal) {
        this.travelTimeTotal = travelTimeTotal;
    }

    public double getTravelTime() {
        return this.travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public double getOilLevel() {
        return this.oilLevel;
    }

    public void setOilLevel(double oilLevel) {
        this.oilLevel = oilLevel;
    }

    public double getBreakFluidLevel() {
        return this.breakFluidLevel;
    }

    public void setBreakFluidLevel(double breakFluidLevel) {
        this.breakFluidLevel = breakFluidLevel;
    }

    public double getFuelLevel() {
        return this.fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean isEngineWarning() {
        return this.engineWarning;
    }

    public boolean getEngineWarning() {
        return this.engineWarning;
    }

    public void setEngineWarning(boolean engineWarning) {
        this.engineWarning = engineWarning;
    }

    public boolean isBreaksWarning() {
        return this.breaksWarning;
    }

    public boolean getBreaksWarning() {
        return this.breaksWarning;
    }

    public void setBreaksWarning(boolean breaksWarning) {
        this.breaksWarning = breaksWarning;
    }

    public boolean isForwardCollisionWarning() {
        return this.forwardCollisionWarning;
    }

    public boolean getForwardCollisionWarning() {
        return this.forwardCollisionWarning;
    }

    public void setForwardCollisionWarning(boolean forwardCollisionWarning) {
        this.forwardCollisionWarning = forwardCollisionWarning;
    }

    public boolean isAirbag() {
        return this.airbag;
    }

    public boolean getAirbag() {
        return this.airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public boolean isServiceCall() {
        return this.serviceCall;
    }

    public boolean getServiceCall() {
        return this.serviceCall;
    }

    public void setServiceCall(boolean serviceCall) {
        this.serviceCall = serviceCall;
    }

    public double getTirePressure() {
        return this.tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public boolean isLightingSystemFailure() {
        return this.lightingSystemFailure;
    }

    public boolean getLightingSystemFailure() {
        return this.lightingSystemFailure;
    }

    public void setLightingSystemFailure(boolean lightingSystemFailure) {
        this.lightingSystemFailure = lightingSystemFailure;
    }

    public double getTemperatureEngine() {
        return this.temperatureEngine;
    }

    public void setTemperatureEngine(double temperatureEngine) {
        this.temperatureEngine = temperatureEngine;
    }

    public double getTemperatureInside() {
        return this.temperatureInside;
    }

    public void setTemperatureInside(double temperatureInside) {
        this.temperatureInside = temperatureInside;
    }

    public double getTemperatureOutside() {
        return this.temperatureOutside;
    }

    public void setTemperatureOutside(double temperatureOutside) {
        this.temperatureOutside = temperatureOutside;
    }

    public double getTemperatureBreaks() {
        return this.temperatureBreaks;
    }

    public void setTemperatureBreaks(double temperatureBreaks) {
        this.temperatureBreaks = temperatureBreaks;
    }

    public double getTemperatureTires() {
        return this.temperatureTires;
    }

    public void setTemperatureTires(double temperatureTires) {
        this.temperatureTires = temperatureTires;
    }

    public double getBreakPower() {
        return this.breakPower;
    }

    public void setBreakPower(double breakPower) {
        this.breakPower = breakPower;
    }

    public boolean isBreakActive() {
        return this.breakActive;
    }

    public boolean getBreakActive() {
        return this.breakActive;
    }

    public void setBreakActive(boolean breakActive) {
        this.breakActive = breakActive;
    }

    public double getGasPower() {
        return this.gasPower;
    }

    public void setGasPower(double gasPower) {
        this.gasPower = gasPower;
    }

    public boolean isGasActive() {
        return this.gasActive;
    }

    public boolean getGasActive() {
        return this.gasActive;
    }

    public void setGasActive(boolean gasActive) {
        this.gasActive = gasActive;
    }

    public boolean isLight() {
        return this.light;
    }

    public boolean getLight() {
        return this.light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public boolean isAcc() {
        return this.acc;
    }

    public boolean getAcc() {
        return this.acc;
    }

    public void setAcc(boolean acc) {
        this.acc = acc;
    }

    public double getMph() {
        return this.mph;
    }

    public void setMph(double mph) {
        this.mph = mph;
    }

    public double getRpm() {
        return this.rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getOxygenLevel() {
        return this.oxygenLevel;
    }

    public void setOxygenLevel(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isInfotainmentOn() {
        return this.infotainmentOn;
    }

    public boolean getInfotainmentOn() {
        return this.infotainmentOn;
    }

    public void setInfotainmentOn(boolean infotainmentOn) {
        this.infotainmentOn = infotainmentOn;
    }

    public String getInfotainmentService() {
        return this.infotainmentService;
    }

    public void setInfotainmentService(String infotainmentService) {
        this.infotainmentService = infotainmentService;
    }

    public double getInfotainmentVolume() {
        return this.infotainmentVolume;
    }

    public void setInfotainmentVolume(double infotainmentVolume) {
        this.infotainmentVolume = infotainmentVolume;
    }

    public double getDirx() {
        return this.dirx;
    }

    public void setDirx(double dirx) {
        this.dirx = dirx;
    }

    public double getDiry() {
        return this.diry;
    }

    public void setDiry(double diry) {
        this.diry = diry;
    }


}

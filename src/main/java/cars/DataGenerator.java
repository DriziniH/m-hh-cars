package cars;
 
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;
import java.util.Arrays;

import cars.data.*;

public class DataGenerator {

    public String getCarData(Car car) {
        /**
         * Calls depending on region the method to create a data object for a car and
         * uses ObjectMapper to create and return a json representation string of that
         * object
         */

        try {
            car = tweekValues(car);
            if (car.getClass() == CarEU.class) {
                return generateRandomDataEU((CarEU) car);
            } else if (car.getClass() == CarUSA.class) {
                return generateRandomDataUSA((CarUSA) car);
            } else {
                return "";
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Car tweekValues(Car car) {
        /**
         * Generates random double in given direction and low probability to change
         * geochip to false
         */
        double lat = car.lat + car.dirX * 0.001;
        double lon = car.lon + car.dirY * 0.001;
        car.setPos(lat, lon);

        if (car.geoChip) {
            car.geoChip = (new Random()).nextFloat() > 0.8;//> 0.005;
        }

        car.mufflerHealth *= 0.99999999999;
        car.tireHealth *= 0.99999999999;
        car.gearsHealth *= 0.99999999999;
        car.breaksHealth *= 0.99999999999;
        car.engineHealth *= 0.99999999999;
        car.batteryHealth *= 0.99999999999;

        return car;
    }

    public String generateRandomDataEU(CarEU carEu) throws JsonProcessingException {
        /**
         * Creates random data for CarEU object, tweeks lat and lon params and returns
         * object as json string
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); // Allow private fields to be serialized

        Random rand = new Random();

        double kilometerTotal = rand.nextInt(100000) + 2000.0 + rand.nextDouble();
        double kilometerStart = rand.nextInt(500) + rand.nextDouble();
        double estimatedRange = rand.nextInt(500) + rand.nextDouble();
        double travelTimeTotal = rand.nextInt(100000000);
        double travelTime = rand.nextInt(500);
        double oilLevel = rand.nextInt(100) + rand.nextDouble();
        double breakFluidLevel = rand.nextInt(100) + rand.nextDouble();
        double fuelLevel = rand.nextInt(100) + rand.nextDouble();
        boolean engineWarning = rand.nextBoolean();
        boolean breaksWarning = rand.nextBoolean();
        boolean forwardCollisionWarning = rand.nextBoolean();
        boolean airbag = rand.nextBoolean();
        boolean serviceCall = rand.nextBoolean();
        double tirePressure = rand.nextInt(100) + rand.nextDouble();
        boolean lightingSystemFailure = rand.nextBoolean();
        double temperatureEngine = rand.nextInt(100) + rand.nextDouble();
        double temperatureInside = rand.nextInt(30) + 10 + rand.nextDouble();
        double temperatureOutside = rand.nextInt(50) - 10 + rand.nextDouble();
        double temperatureBreaks = rand.nextInt(100) + rand.nextDouble();
        double temperatureTires = rand.nextInt(100) + rand.nextDouble();
        double breakPower = rand.nextInt(100) + rand.nextDouble();
        boolean breakActive = rand.nextBoolean();
        double gasPower = rand.nextInt(100) + rand.nextDouble();
        boolean gasActive = rand.nextBoolean();
        boolean light = rand.nextBoolean();
        boolean acc = rand.nextBoolean();

        double kmh = rand.nextInt(200) + rand.nextDouble();
        if ((new Random()).nextFloat() < 0.2) { // 20% change car stopping
            kmh = 0.0;
        }

        double rpm = rand.nextInt(6000) + rand.nextDouble();
        double oxygenLevel = rand.nextInt(100) + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        double consumptionKm = rand.nextInt(10) + 5 + rand.nextDouble();
        double co2Km = consumptionKm * 24;
        boolean rapidSteeringWheelMovement = rand.nextBoolean();
        boolean drivingOnMarkers = rand.nextBoolean();

        carEu.setValues(kilometerTotal, kilometerStart, estimatedRange, travelTimeTotal, travelTime, oilLevel,
                breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning, airbag, serviceCall,
                tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside, temperatureOutside,
                temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive, light, acc, kmh, rpm,
                oxygenLevel, infotainmentOn, infotainmentService, infotainmentVolume, consumptionKm, co2Km,
                rapidSteeringWheelMovement, drivingOnMarkers

        );

        return objectMapper.writeValueAsString(carEu);

    }

    public String generateRandomDataUSA(CarUSA carUsa) throws JsonProcessingException {
        /**
         * Creates random data for CarUSA object, tweeks lat and lon params and returns
         * object as json string
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); // Allow private fields to be serialized

        Random rand = new Random();

        double mileageTotal = rand.nextInt(100000) + 2000.0 + rand.nextDouble();
        double mileageStart = rand.nextInt(500) + rand.nextDouble();
        double estimatedRange = rand.nextInt(500) + rand.nextDouble();
        double travelTimeTotal = rand.nextInt(100000000);
        double travelTime = rand.nextInt(500);
        double oilLevel = rand.nextInt(100) + rand.nextDouble();
        double breakFluidLevel = rand.nextInt(100) + rand.nextDouble();
        double fuelLevel = rand.nextInt(100) + rand.nextDouble();
        boolean engineWarning = rand.nextBoolean();
        boolean breaksWarning = rand.nextBoolean();
        boolean forwardCollisionWarning = rand.nextBoolean();
        boolean airbag = rand.nextBoolean();
        boolean serviceCall = rand.nextBoolean();
        double tirePressure = rand.nextInt(100) + rand.nextDouble();
        boolean lightingSystemFailure = rand.nextBoolean();
        double temperatureEngine = rand.nextInt(100) + rand.nextDouble();
        double temperatureInside = rand.nextInt(30) + 10 + rand.nextDouble();
        double temperatureOutside = rand.nextInt(50) - 10 + rand.nextDouble();
        double temperatureBreaks = rand.nextInt(100) + rand.nextDouble();
        double temperatureTires = rand.nextInt(100) + rand.nextDouble();
        double breakPower = rand.nextInt(100) + rand.nextDouble();
        boolean breakActive = rand.nextBoolean();
        double gasPower = rand.nextInt(100) + rand.nextDouble();
        boolean gasActive = rand.nextBoolean();
        boolean light = rand.nextBoolean();
        boolean acc = rand.nextBoolean();

        double mph = rand.nextInt(200) + rand.nextDouble();
        if ((new Random()).nextFloat() < 0.2) { // 20% change car stopping
            mph = 0.0;
        }

        double rpm = rand.nextInt(6000) + rand.nextDouble();
        double oxygenLevel = rand.nextInt(100) + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        double consumptionMile = rand.nextInt(10) + 5 + rand.nextDouble();
        double co2Mile = consumptionMile * 24;
        boolean rapidSteeringWheelMovement = rand.nextBoolean();
        boolean drivingOnMarkers = rand.nextBoolean();

        carUsa.setValues(mileageTotal, mileageStart, estimatedRange, travelTimeTotal, travelTime, oilLevel,
                breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning, airbag, serviceCall,
                tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside, temperatureOutside,
                temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive, light, acc, mph, rpm,
                oxygenLevel, infotainmentOn, infotainmentService, infotainmentVolume, consumptionMile, co2Mile,
                rapidSteeringWheelMovement, drivingOnMarkers);

        return objectMapper.writeValueAsString(carUsa);
    }
}

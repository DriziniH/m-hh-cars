package cars;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

import cars.data.*;

public class DataGenerator {

    public String getCarData(Object car) {
        /**
         * Calls depending on region the method to create a data object for a car and
         * uses ObjectMapper to create and return a json representation string of that
         * object
         */

        try {
            if (car.getClass() == CarEU.class) {
                car = driveInDirectionEU((CarEU) car);
                return generateRandomDataEU((CarEU) car);
            } else if (car.getClass() == CarUSA.class) {
                car = driveInDirectionUSA((CarUSA) car);
                return generateRandomDataUSA((CarUSA) car);
            } else if (car.getClass() == CarChina.class) {
                car = driveInDirectionChina((CarChina) car);
                return generateRandomDataChina((CarChina) car);
            } else {
                return "";
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public CarEU driveInDirectionEU(CarEU carEu) {
        /**
         * Generates random double in given direction
         */
        double lat = carEu.lat + carEu.dirX * 0.001;
        double lon = carEu.lon + carEu.dirY * 0.001;
        carEu.setPos(lat, lon);
        return carEu;
    }

    public CarUSA driveInDirectionUSA(CarUSA carUsa) {
        /**
         * Generates random double in given direction
         */
        double lat = carUsa.lat + carUsa.dirX * 0.001;
        double lon = carUsa.lon + carUsa.dirY * 0.001;
        carUsa.setPos(lat, lon);
        return carUsa;
    }

    public CarChina driveInDirectionChina(CarChina carChina) {
        /**
         * Generates random double in given direction
         */
        double lat = carChina.lat + carChina.dirX * 0.001;
        double lon = carChina.lon + carChina.dirY * 0.001;
        carChina.setPos(lat, lon);
        return carChina;
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
        double rpm = rand.nextInt(6000) + rand.nextDouble();
        double oxygenLevel = rand.nextInt(100) + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        carEu.setValues(kilometerTotal, kilometerStart, estimatedRange, travelTimeTotal, travelTime, oilLevel,
                breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning, airbag, serviceCall,
                tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside, temperatureOutside,
                temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive, light, acc, kmh, rpm,
                oxygenLevel, infotainmentOn, infotainmentService, infotainmentVolume);

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
        double rpm = rand.nextInt(6000) + rand.nextDouble();
        double oxygenLevel = rand.nextInt(100) + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        carUsa.setValues(mileageTotal, mileageStart, estimatedRange, travelTimeTotal, travelTime, oilLevel,
                breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning, airbag, serviceCall,
                tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside, temperatureOutside,
                temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive, light, acc, mph, rpm,
                oxygenLevel, infotainmentOn, infotainmentService, infotainmentVolume);

        return objectMapper.writeValueAsString(carUsa);
    }

    public String generateRandomDataChina(CarChina carChina) throws JsonProcessingException {
        /**
         * Creates random data for CarChina object, tweeks lat and lon params and
         * returns object as json string
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); // Allow private fields to be serialized

        Random rand = new Random();

        String 模型 = "甲级";
        List<String> 标签 = Arrays.asList("本泽");
        String 燃料 = "柴油";
        double 千米_总 = rand.nextInt(100) + rand.nextDouble();
        double 千米 = rand.nextInt(100) + rand.nextDouble();
        double 旅行_时候_总 = rand.nextInt(100) + rand.nextDouble();
        double 旅行_时候 = rand.nextInt(100) + rand.nextDouble();
        double 油_层次 = rand.nextInt(100) + rand.nextDouble();
        double 断裂_流畅_层次 = rand.nextInt(100) + rand.nextDouble();
        double 燃料_层次 = rand.nextInt(100) + rand.nextDouble();
        double 发动机 = rand.nextInt(100) + rand.nextDouble();
        double 休息 = rand.nextInt(100) + rand.nextDouble();
        double 胎压 = rand.nextInt(100) + rand.nextDouble();

        carChina.setValues(模型, 标签, 燃料, 千米_总, 千米, 旅行_时候_总, 旅行_时候, 油_层次, 断裂_流畅_层次, 燃料_层次, 发动机, 休息, 胎压);
        return objectMapper.writeValueAsString(carChina);
    }
}

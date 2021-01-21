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

    public String getCarData(String region, String id) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); //Allow private fields to be serialized

        try {
            switch (region.toLowerCase()) {
                case "eu":
                    CarEU carEU = generateRandomDataEU(id);
                    return objectMapper.writeValueAsString(carEU);
                case "usa":
                    CarUSA carUSA = generateRandomDataUSA(id);
                    return objectMapper.writeValueAsString(carUSA);
                case "china":
                    CarChina carChina = generateRandomDataChina(id);
                    return objectMapper.writeValueAsString(carChina);
                default:
                    System.out.println("Region not available: " + region);
                    return "";
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public CarEU generateRandomDataEU(String id) {
        Random rand = new Random();

        String model = Arrays.asList("A-Klasse", "B-Klasse", "C-Klasse", "E-Klasse", "G-Klasse").get(rand.nextInt(5));
        List<String> labels = Arrays.asList(model, "Benzer");
        String fuel = Arrays.asList("gasonline", "diesel", "gas", "electric").get(rand.nextInt(4));
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
        double lat = rand.nextInt(7) + 38 + rand.nextDouble();
        double lon = rand.nextInt(45) - 78 + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        return new CarEU(id, model, labels, fuel, kilometerTotal, kilometerStart, estimatedRange, travelTimeTotal,
                travelTime, oilLevel, breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning,
                airbag, serviceCall, tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside,
                temperatureOutside, temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive,
                light, acc, kmh, rpm, oxygenLevel, lat, lon, infotainmentOn, infotainmentService, infotainmentVolume);
    }

    public CarUSA generateRandomDataUSA(String id) {
        Random rand = new Random();

        String model = Arrays.asList("A-Klasse", "B-Klasse", "C-Klasse", "E-Klasse", "G-Klasse").get(rand.nextInt(5));
        List<String> labels = Arrays.asList(model, "Benzer");
        String fuel = Arrays.asList("gasonline", "diesel", "gas", "electric").get(rand.nextInt(4));
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
        double lat = rand.nextInt(7) + 38 + rand.nextDouble();
        double lon = rand.nextInt(45) - 78 + rand.nextDouble();
        boolean infotainmentOn = rand.nextBoolean();
        String infotainmentService = Arrays.asList("Navigation", "FM", "Mobile Phone", "Information System")
                .get(rand.nextInt(4));
        double infotainmentVolume = rand.nextInt(100) + rand.nextDouble();

        return new CarUSA(id, model, labels, fuel, mileageTotal, mileageStart, estimatedRange, travelTimeTotal,
                travelTime, oilLevel, breakFluidLevel, fuelLevel, engineWarning, breaksWarning, forwardCollisionWarning,
                airbag, serviceCall, tirePressure, lightingSystemFailure, temperatureEngine, temperatureInside,
                temperatureOutside, temperatureBreaks, temperatureTires, breakPower, breakActive, gasPower, gasActive,
                light, acc, mph, rpm, oxygenLevel, lat, lon, infotainmentOn, infotainmentService, infotainmentVolume);
    }

    public CarChina generateRandomDataChina(String id) {
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

        return new CarChina(id, 模型, 标签, 燃料, 千米_总, 千米, 旅行_时候_总, 旅行_时候, 油_层次, 断裂_流畅_层次, 燃料_层次, 发动机, 休息, 胎压);
    }
}

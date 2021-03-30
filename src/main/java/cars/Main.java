package cars;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cars.utility.ConfigLoader;

public class Main {
    public static void main(String[] args) {

        Properties kafkaPropertiesEU = null;
        Properties kafkaPropertiesUSA = null;

        try {
            kafkaPropertiesEU = (new ConfigLoader()).getProperties("kafka-eu.properties");
            kafkaPropertiesUSA = (new ConfigLoader()).getProperties("kafka-usa.properties");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        // EU
        for (int i = 0; i < 100; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaPropertiesEU, "eu", randId));
        }

        // USA
        for (int i = 0; i < 0; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaPropertiesUSA, "usa", randId));
        }

    }
}

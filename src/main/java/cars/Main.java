package cars;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cars.utility.ConfigLoader;

public class Main {
    public static void main(String[] args) {

        Properties kafkaProperties = null;

        try {
            kafkaProperties = (new ConfigLoader()).getProperties("kafka.properties");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        // EU
        for (int i = 0; i < 5; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaProperties, "car-eu", "eu", randId));
        }

        // USA
        for (int i = 0; i < 5; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaProperties, "car-usa", "usa", randId));
        }

    }
}

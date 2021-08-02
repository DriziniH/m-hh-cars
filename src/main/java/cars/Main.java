package cars;

import java.util.Arrays;
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
        executor.execute(new ProducerKafka(kafkaProperties, "eu", "300b0247-632d-4401-97e7-f86f5fb7e8d3", false));
        executor.execute(new ConsumerKafka(kafkaProperties, Arrays.asList("car-analysis"),"300b0247-632d-4401-97e7-f86f5fb7e8d3", true));
        
        // EU
        for (int i = 0; i < 20; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaProperties, "eu", randId, false));
        }

        // USA
        for (int i = 0; i < 20; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(kafkaProperties, "usa", randId, false));
        }

    }
}

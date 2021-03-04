package cars;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cars.producers.*;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "kafka:9092,localhost:9093");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        
        ExecutorService executor = Executors.newCachedThreadPool();

        //EU
        for (int i = 0; i < 5; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(properties, "car-eu", "eu", randId ));
        }
        
        //USA
        for (int i = 0; i < 5; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKafka(properties, "car-usa", "usa", randId ));
        }

    }
}

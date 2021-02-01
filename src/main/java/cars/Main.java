package cars;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cars.kafka.Producer;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.put("group.id", "car");
        
        ExecutorService executor = Executors.newCachedThreadPool();

        //EU
        for (int i = 0; i < 20; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new Producer(properties, "car-eu", "eu", randId ));
            // executor.execute(new Consumer(properties, Arrays.asList("car-eu")));
        }
        
        //USA
        for (int i = 0; i < 20; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new Producer(properties, "car-usa", "usa", randId ));
            // executor.execute(new Consumer(properties, Arrays.asList("car-eu")));
        }
        
        //CHINA
        for (int i = 0; i < 20; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new Producer(properties, "car-china", "china", randId ));
            // executor.execute(new Consumer(properties, Arrays.asList("car-eu")));
        }
    }
}

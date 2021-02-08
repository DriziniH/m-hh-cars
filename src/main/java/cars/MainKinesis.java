package cars;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import cars.producers.ProducerKinesis;

public class MainKinesis {

    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            InputStream stream = new FileInputStream(
                    "C:\\Showcase\\Projekt\\M-HH-cars\\src\\main\\resources\\aws.properties");
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        // EU
        for (int i = 0; i < 30; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKinesis(randId, "eu-central-1", "car", 
                    props.getProperty("aws.access.key"),props.getProperty("aws.secret.key")));
        }

        // USA
        for (int i = 0; i < 30; i++) {
            String randId = UUID.randomUUID().toString();
            executor.execute(new ProducerKinesis(randId, "usa-east-2", "car", props.getProperty("accessKey"),
                    props.getProperty("secretKey")));
        }
    }
}

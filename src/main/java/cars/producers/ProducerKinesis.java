package cars.producers;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;

import cars.DataGenerator;
import cars.data.*;

public class ProducerKinesis implements Runnable {

    String id;
    boolean active;
    String region;
    String stream;
    DataGenerator dataGenerator;
    AmazonKinesis kinesisClient;
    PutRecordsRequest putRecord;

    private String accessKey;
    private String secretKey;

    private AmazonKinesis buildKinesisClient() {

        AmazonKinesisClientBuilder clientBuilder = AmazonKinesisClientBuilder.standard();

        clientBuilder.setRegion(region);
        clientBuilder.setCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)));

        return clientBuilder.build();
    }

    public ProducerKinesis(String id, String region, String stream, String accessKey,
            String secretKey) {
        this.id = id;
        this.active = true;
        this.region = region;
        this.stream = stream;
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        dataGenerator = new DataGenerator();
        kinesisClient = buildKinesisClient();
    }

    @Override
    public void run() {

        while (active) {
            /**
             * Generates random data with fixed car id based on the region and infinitly
             * publishes data to kafka topic
             */

            System.out.println("Started kinesis producer thread. Region " + this.region + " | Topic: " + this.stream);

            Object car = new Object();

            // Initialize random consistent values for each car
            Random rand = new Random();
            String model = Arrays.asList("A-Klasse", "B-Klasse", "C-Klasse", "E-Klasse", "G-Klasse")
                    .get(rand.nextInt(5));
            List<String> labels = Arrays.asList(model, "Benzer");
            String fuel = Arrays.asList("gasonline", "diesel", "gas", "electric").get(rand.nextInt(4));

            switch (this.region.toLowerCase()) {
                case "eu-central-1":
                    car = new CarEU(id, model, labels, fuel);
                    break;
                case "usa-east-2":
                    car = new CarUSA(id, model, labels, fuel);
                    break;
                case "china":
                    car = new CarChina(id);
                    break;
                default:
                    System.out.println("Region not available: " + region);
                    return;
            }

            while (active) {
                ByteBuffer data = ByteBuffer.wrap(dataGenerator.getCarData(car).getBytes());
                try {
                    kinesisClient.putRecord(stream, data, id);
                } catch (AmazonClientException ex) {
                    System.out.println("Error sending record to Amazon Kinesis." + ex.toString());
                }
            }

        }

    }

}

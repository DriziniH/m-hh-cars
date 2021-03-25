package cars;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import cars.data.*;

public class ProducerKafka implements Runnable {
    /**
     * Producer Thread to publish data to Kafka
     */

    Properties properties;
    String topic;
    String id;
    String region;
    boolean active = true;
    KafkaProducer<byte[], byte[]> producer;
    ProducerRecord<byte[], byte[]> producerRecord;
    DataGenerator dataGenerator = new DataGenerator();

    public ProducerKafka(Properties properties, String topic, String region, String id) {
        this.properties = properties;
        this.topic = topic;
        this.id = id;
        this.region = region;
        this.producer = new KafkaProducer<byte[], byte[]>(properties);
    }

    public void terminateThread() {
        this.active = false;
    }

    @Override
    public void run() {
        /**
         * Generates random data with fixed car id based on the region and infinitly
         * publishes data to kafka topic
         */

        System.out.println("Started kafka producer thread. Region " + this.region + " | Topic: " + this.topic);

        Object car = new Object();

        // Initialize random consistent values for each car
        Random rand = new Random();
        String model = Arrays.asList("A-Klasse", "B-Klasse", "C-Klasse", "E-Klasse", "G-Klasse").get(rand.nextInt(5));
        List<String> labels = Arrays.asList(model, "Benzer");
        String fuel = Arrays.asList("gasonline", "diesel", "gas", "electric").get(rand.nextInt(4));

        switch (this.region.toLowerCase()) {
            case "eu":
                car = new CarEU(id, model, labels, fuel);
                break;
            case "usa":
                car = new CarUSA(id, model, labels, fuel);
                break;
            default:
                System.out.println("Region not available: " + region);
                return;
        }

        while (active) {

            String data = dataGenerator.getCarData(car);

            this.producerRecord = new ProducerRecord<byte[], byte[]>(this.topic, data.getBytes());
            producer.send(producerRecord);

            producer.send(producerRecord, (metadata, exception) -> {
                if (metadata == null) {
                    exception.printStackTrace();
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

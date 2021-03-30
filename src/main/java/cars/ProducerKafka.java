package cars;

import java.util.ArrayList;
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
    DataGenerator dataGenerator = new DataGenerator();

    public ProducerKafka(Properties kafkaProperties, String region, String id) {
        this.properties = kafkaProperties;
        this.topic = kafkaProperties.getProperty("topic");
        this.id = id;
        this.region = region;
        this.producer = new KafkaProducer<byte[], byte[]>(kafkaProperties);
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

        Car car;

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

        List<ProducerRecord<byte[], byte[]>> recordsToSend = new ArrayList<ProducerRecord<byte[], byte[]>>();
        List<ProducerRecord<byte[], byte[]>> recordsToRemove = new ArrayList<ProducerRecord<byte[], byte[]>>();
        while (active) {

            String carDataJson = dataGenerator.getCarData(car);
            recordsToSend.add(new ProducerRecord<byte[], byte[]>(this.topic, carDataJson.getBytes()));

            for (ProducerRecord<byte[], byte[]> producerRecord : recordsToSend) {
                producer.send(producerRecord, (metadata, exception) -> {
                    if (metadata == null) {
                        exception.printStackTrace();
                    }else{
                        recordsToRemove.add(producerRecord);
                    }
                });
            }

            recordsToSend.removeAll(recordsToRemove);
            recordsToRemove.clear();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

package cars;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer implements Runnable {

    Properties properties;
    String topic;
    String id;
    String region;
    boolean active = true;
    KafkaProducer<byte[], byte[]> producer;
    ProducerRecord<byte[], byte[]> producerRecord;
    DataGenerator dataGenerator = new DataGenerator();

    public Producer(Properties properties, String topic, String region, String id) {
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
        System.out.println("Started Producer Thread");
        while (active) {
            String data = dataGenerator.getCarData(region, this.id);
            this.producerRecord = new ProducerRecord<byte[], byte[]>(topic, data.getBytes());
            producer.send(producerRecord);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

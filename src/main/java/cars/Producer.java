package cars;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer implements Runnable {

    Properties properties;
    boolean active;
    KafkaProducer<byte[], byte[]> producer;
    ProducerRecord<byte[], byte[]> producerRecord;

    public Producer(Properties properties, String key, String value) {
        this.properties = properties;
        this.active = true;

        this.producer = new KafkaProducer<byte[], byte[]>(properties);
        this.producerRecord = new ProducerRecord<byte[], byte[]>("car-eu", key.getBytes(), value.getBytes());
    }

    public void terminateThread() {
        this.active = false;
    }

    @Override
    public void run() {
        System.out.println("Started Producer Thread");
        while (active) {
            producer.send(producerRecord);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

package cars;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class ConsumerKafka implements Runnable {
    /**
     * Consumer Thread to read data from kafka
     */

    Properties properties;
    List<String> topics;
    boolean active;
    KafkaConsumer<byte[], byte[]> consumer;
    String id;
    Boolean print;

    public ConsumerKafka(Properties properties, List<String> topics, String id, Boolean print) {
        this.properties = properties;
        this.topics = topics;
        this.active = true;
        this.print = print;
        this.consumer = new KafkaConsumer<byte[], byte[]>(properties);
        this.consumer.subscribe(topics);
        this.id = id;
    }

    public void terminateThread() {
        this.active = false;
    }

    @Override
    public void run() {
        /**
         * Infinitly reads kafka topic
         */

        System.out.println("Started Consumer Thread");
        while (active) {
            ConsumerRecords<byte[], byte[]> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<byte[], byte[]> record : records) {
                if (new String(record.key(), StandardCharsets.UTF_8).contains("300b0247-632d-4401-97e7-f86f5fb7e8d3") && print) {
                    System.out.println(new String(record.value(), StandardCharsets.UTF_8));
                }
            }
        }
        consumer.close();
        System.out.println("DONE");
    }
}

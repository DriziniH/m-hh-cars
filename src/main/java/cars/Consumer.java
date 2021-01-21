package cars;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class Consumer implements Runnable {

    Properties properties;
    List<String> topics;
    boolean active;
    KafkaConsumer<byte[], byte[]> consumer;

    public Consumer(Properties properties, List<String> topics) {
        this.properties = properties;
        this.topics = topics;
        this.active = true;
        this.consumer = new KafkaConsumer<byte[], byte[]>(properties);
        this.consumer.subscribe(topics);
    }

    public void terminateThread() {
        this.active = false;
    }

    @Override
    public void run() {
        System.out.println("Started Consumer Thread");
        while (active) {
            ConsumerRecords<byte[], byte[]> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<byte[], byte[]> record : records) {
                // System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(),
                // new String(record.key(), StandardCharsets.UTF_8),
                // new String(record.value(), StandardCharsets.UTF_8));
            }
        }
        consumer.close();
        System.out.println("DONE");
    }
}

package us.inest.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record =
                new ProducerRecord<>("my-topic", "key-1", "Hello Kafka!");

        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Sent to: " + metadata.topic() + " Partition: " + metadata.partition());
            } else {
                exception.printStackTrace();
            }
        });

        producer.close();
    }
}

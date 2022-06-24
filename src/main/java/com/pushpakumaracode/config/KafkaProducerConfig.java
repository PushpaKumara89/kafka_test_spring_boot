package com.pushpakumaracode.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServers;

    public ProducerFactory<String, ?> producerConfig(){
        HashMap<String,Object > props =new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 2147483647);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 2147483647);
        return new DefaultKafkaProducerFactory<>(props);
    }

   /* @Bean
    public ProducerFactory<String, ?> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }*/

    @Bean
    public KafkaTemplate<String, ?> kafkaTemplate(){
        return new KafkaTemplate<>(producerConfig());
    }

}

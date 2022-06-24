package com.pushpakumaracode.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic pushpaKumaraCodeTopic(){
        return TopicBuilder.name("kumara").partitions(1).replicas(1)
                .build();
    }


}












//===========================================================
/*
TopicBuilder.name("Pushpakumara").partitions(1).replicas(1)
                .build();
*///Kafcaka 2.3

/*TopicBuilder.name("Pushpakumara")
        .build();*///Kafcaka 2.7.1

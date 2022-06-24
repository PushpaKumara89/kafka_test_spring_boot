package com.pushpakumaracode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, byte[]> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 3; i++) {
				byte[] bytes ={12,34,54,65};
				kafkaTemplate.send("pushpakumara",bytes);
			}
		};
	}*/
}

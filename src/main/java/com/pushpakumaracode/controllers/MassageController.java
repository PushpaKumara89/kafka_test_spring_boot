package com.pushpakumaracode.controllers;
import com.pushpakumaracode.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping(value = "api/v1/massages")
public class MassageController {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;


    public MassageController(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("")
    public ResponseEntity<Object> publish(@RequestBody Order Order){
        /*kafkaTemplate.send("kumara", Order);*/
        return new ResponseEntity<Object>("The massage Sand Successfully", HttpStatus.OK);
    }


    @PostMapping("/image")
    public ResponseEntity<Object> image(@RequestParam("File") MultipartFile file) throws IOException {
        kafkaTemplate.send("kumara",file.getBytes());
        return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }


}

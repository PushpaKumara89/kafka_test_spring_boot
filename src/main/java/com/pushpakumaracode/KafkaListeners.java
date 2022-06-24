package com.pushpakumaracode;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kumara",
            groupId = "groupId", containerFactory = "defaultListener"
    )

    void listener(byte[] data){
        if (data.length==0){
            System.out.println("Attachment went wrong .............");
        }else {
            Date time =new Date();
            String t=new SimpleDateFormat("yyyy_MM_dd_hh_mm-ss_ms ").format(time);

            File file = new File(t+"Kaf.ka.jpg");
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(data);
                outputStream.close();
                System.out.println("Save Successfully...................");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
      /*  System.out.println("Listener received: "+data+"  ->>>>");*/

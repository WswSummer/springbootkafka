package com.wsw.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangSongWen
 * @Date: Created in 9:33 2020/7/16
 * @Description:
 */
@RestController
public class sendMessageController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message) {
        kafkaTemplate.send("testTopic", message);
        return true;
    }
}

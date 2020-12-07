package com.wsw.springbootkafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author WangSongWen
 * @Date: Created in 9:37 2020/7/16
 * @Description:
 */
@Component
public class ConsumerListener {
    @KafkaListener(id = "consumer1", groupId = "wswGroup", topics = "wswTopic")
    public void onMessage(String message) {
        System.out.println(message);
    }
}

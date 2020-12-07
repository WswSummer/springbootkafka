package com.wsw.springbootkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangSongWen
 * @Date: Created in 9:33 2020/7/16
 * @Description:
 */
@RestController
@Slf4j
public class sendMessageController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/message/send")
    public void send(@RequestParam String message) {
        kafkaTemplate.send("wswTopic", message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("消息发送失败! " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("消息发送成功! " + result.getRecordMetadata().topic() + "-" + result.getRecordMetadata().partition() + "-" +
                        result.getRecordMetadata().offset());
            }
        });
    }
}

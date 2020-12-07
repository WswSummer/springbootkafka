package com.wsw.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @Author WangSongWen
 * @Date: Created in 16:38 2020/12/7
 * @Description:
 */
@Configuration
public class KafkaConfig {
    @Bean
    public KafkaAdmin admin(KafkaProperties properties){
        KafkaAdmin admin = new KafkaAdmin(properties.buildAdminProperties());
        admin.setFatalIfBrokerNotAvailable(true);
        return admin;
    }

    @Bean
    public NewTopic myTopic(){
        return new NewTopic("wswTopic", 1, (short) 1);
    }
}

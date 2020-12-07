package com.wsw.springbootkafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.io.IOException;

@SpringBootTest
@EmbeddedKafka(count = 2, ports = {9092, 9093})  // 启动一个Kafka Server服务, 包含2个Broker节点
class SpringbootkafkaApplicationTests {

    @Test
    void contextLoads() throws IOException {
        System.in.read();
    }

}

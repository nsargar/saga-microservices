package com.prongzz.sagatutorial.serviceTest;

import com.prongzz.sagatutorial.entity.Order;
import com.prongzz.sagatutorial.kafka.publishers.OrderPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

@SpringBootTest
public class OrderPublisherTest {

  @Autowired
  OrderPublisher orderPublisher;

  @Test
  void sendKafkaOrderMessage() {
    StepVerifier.create(
    orderPublisher.sendOrderSavedEvent("order-topic",new Order(null, LocalDateTime.now(),"Nilesh"))
    ).expectNextMatches(senderResult -> senderResult.recordMetadata().hasOffset());

  }
}

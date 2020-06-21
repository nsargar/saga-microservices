package com.prongzz.sagatutorial.serviceTest;

import com.prongzz.sagatutorial.entity.Order;
import com.prongzz.sagatutorial.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

@SpringBootTest
public class OrderServiceTests {

  @Autowired OrderService orderService;

  @Test
  void saveRecordInMongoDb() {
    Order order = new Order(null, LocalDateTime.now(), "Nilesh");

    StepVerifier.create(orderService.saveOrder(new Order(null, LocalDateTime.now(), "Nilesh")))
        .expectSubscription()
        .expectNextMatches(order1 -> order1.getCreatedBy().equals("Nilesh"))
        .verifyComplete();
  }
}

package com.prongzz.sagatutorial.kafka.publishers;

import com.prongzz.sagatutorial.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

@Service
@RequiredArgsConstructor
public class OrderPublisherImpl implements OrderPublisher {

  private final ReactiveKafkaProducerTemplate reactiveKafkaProducerTemplate;

  @Override
  public Mono<SenderResult> sendOrderSavedEvent(String s, Order order) {
    return reactiveKafkaProducerTemplate.send("order-topic", order);
  }
}

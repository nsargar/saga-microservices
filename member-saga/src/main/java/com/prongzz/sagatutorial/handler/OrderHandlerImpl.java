package com.prongzz.sagatutorial.handler;

import com.prongzz.sagatutorial.entity.Order;
import com.prongzz.sagatutorial.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class OrderHandlerImpl implements OrderHandler {

  private final OrderService orderService;

  @Autowired()
  @Lazy
  @Qualifier("rsocketUpperCaseRequestFlow.gateway")
  private Function<Mono<String>, String> rsocketUpperCaseFlowFunction; // request-response
  //private Function<Flux<String>, Flux<String>> rsocketUpperCaseFlowFunction; request-channel

  @Override
  public Mono<ServerResponse> saveOrder(ServerRequest request) {
    Mono<String> m = Mono.just("asdaasd");
    System.out.println(rsocketUpperCaseFlowFunction.apply(Mono.just("a")));
    ;
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(request.bodyToMono(Order.class).flatMap(orderService::saveOrder), Order.class);
  }
}

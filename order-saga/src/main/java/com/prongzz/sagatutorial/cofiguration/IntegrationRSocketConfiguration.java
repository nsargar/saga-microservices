package com.prongzz.sagatutorial.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.rsocket.RSocketInteractionModel;
import org.springframework.integration.rsocket.ServerRSocketConnector;
import org.springframework.integration.rsocket.ServerRSocketMessageHandler;
import org.springframework.integration.rsocket.dsl.RSockets;
import org.springframework.messaging.rsocket.RSocketStrategies;
import reactor.core.publisher.Flux;

@Configuration
public class IntegrationRSocketConfiguration {

  @Bean
  ServerRSocketMessageHandler serverRSocketMessageHandler(RSocketStrategies rSocketStrategies) {
    ServerRSocketMessageHandler handler = new ServerRSocketMessageHandler(true);
    handler.setRSocketStrategies(rSocketStrategies);
    return handler;
  }

  @Bean
  public ServerRSocketConnector serverRSocketConnector(
      ServerRSocketMessageHandler serverRSocketMessageHandler) {
    return new ServerRSocketConnector(serverRSocketMessageHandler);
  }

  @Bean
  public IntegrationFlow rsocketUpperCaseFlow(ServerRSocketConnector serverRSocketConnector) {
    return IntegrationFlows.from(
            RSockets.inboundGateway("/uppercase")
                .requestElementType(ResolvableType.forClass(String.class))
                .interactionModels(RSocketInteractionModel.requestResponse)
                .rsocketConnector(serverRSocketConnector))
        .log("Request came")
        .<Flux<String>, Flux<String>>transform(stringFlux -> stringFlux.map(String::toUpperCase))
        .get();
  }
}

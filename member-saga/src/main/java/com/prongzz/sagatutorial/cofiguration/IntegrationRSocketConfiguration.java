package com.prongzz.sagatutorial.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.rsocket.ClientRSocketConnector;
import org.springframework.integration.rsocket.RSocketInteractionModel;
import org.springframework.integration.rsocket.dsl.RSockets;

import java.util.function.Function;

@Configuration
public class IntegrationRSocketConfiguration {

  @Bean
  public ClientRSocketConnector clientRSocketConnector() {
    ClientRSocketConnector clientRSocketConnector = new ClientRSocketConnector("localhost", 9090);
    clientRSocketConnector.setAutoStartup(false);
    return clientRSocketConnector;
  }

  @Bean
  public IntegrationFlow rsocketUpperCaseRequestFlow(
      ClientRSocketConnector clientRSocketConnector) {
    return IntegrationFlows.from(Function.class)
        .handle(
            RSockets.outboundGateway("/uppercase")
                .interactionModel(message -> RSocketInteractionModel.requestResponse)
                .clientRSocketConnector(clientRSocketConnector))
        .get();
  }
}

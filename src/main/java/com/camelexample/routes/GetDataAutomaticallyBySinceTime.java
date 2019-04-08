package com.camelexample.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class GetDataAutomaticallyBySinceTime extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:GetDataAutoBySinceTime")
      .routeId("GetDataAutoBySinceTime")
      .autoStartup(true)
      .removeHeaders("*")
      .setHeader(Exchange.HTTP_METHOD, constant("GET"))
      .toD("http4:${header.targetAddress}/command=${header.query}%26httpClient.socketTimeout=3000")
      .convertBodyTo(String.class, "utf-8")
      .to("direct:PostMessageInActiveMQ");
  }
}

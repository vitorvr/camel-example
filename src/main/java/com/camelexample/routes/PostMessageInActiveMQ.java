package com.camelexample.routes;

import org.apache.camel.builder.RouteBuilder;
import com.camelexample.components.CamelArtemisComponent;

public class PostMessageInActiveMQ extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    CamelArtemisComponent components = new CamelArtemisComponent();

    getContext().addComponent("artemis", components.getArtemisComponent());

    from("direct:PostMessageInActiveMQ")
      .routeId("PostMessageInActiveMQ")
      .autoStartup(true)
      .convertBodyTo(String.class, "utf-8")
      .inOnly("artemis:ARTEMIS.QUEUE");
  }


}

package com.camelexample.routes;

import org.apache.camel.builder.RouteBuilder;
import com.camelexample.processors.GetCurrentDate;

public class Route1 extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    from("timer:Route1Timer?period=15m")
      .routeId("Route1")
      .autoStartup(false)
      .setProperty("targetAddress", simple("hostname.route1"))
      .process(new GetCurrentDate())
      .setProperty("query",
          simple("DataQuery%26URI=Route1%26format=xml%26Mode=since-time%26p1=${header.currentDate}"))
      .to("direct:GetDataAutoBySinceTime");
  }
}

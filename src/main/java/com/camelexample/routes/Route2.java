package com.camelexample.routes;

import org.apache.camel.builder.RouteBuilder;
import com.camelexample.processors.GetCurrentDate;

public class Route2 extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    from("timer:Route2Timer?period=15m")
      .routeId("Route2")
      .autoStartup(false)
      .setProperty("targetAddress", simple("hostname.route2"))
      .process(new GetCurrentDate())
      .setProperty("query",
          simple("DataQuery%26URI=Route2%26format=xml%26Mode=since-time%26p1=${header.currentDate}"))
      .to("direct:GetDataAutoBySinceTime");
  }
}

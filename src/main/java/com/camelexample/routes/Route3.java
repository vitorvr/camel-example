package com.camelexample.routes;

import org.apache.camel.builder.RouteBuilder;
import com.camelexample.processors.GetCurrentDate;

public class Route3 extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    from("timer:Route3Timer?period=15m")
      .routeId("Route3")
      .autoStartup(false)
      .setProperty("targetAddress", simple("hostname.route3"))
      .process(new GetCurrentDate())
      .setProperty("query",
          simple("DataQuery%26URI=Route3%26format=xml%26Mode=since-time%26p1=${header.currentDate}"))
      .to("direct:GetDataAutoBySinceTime");
  }
}

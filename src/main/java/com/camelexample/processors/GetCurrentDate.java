package com.camelexample.processors;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetCurrentDate implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.add(Calendar.HOUR, -12);

        SimpleDateFormat outputFmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        outputFmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        exchange.setProperty("currentDate", outputFmt.format(calendar.getTime()));
    }
}
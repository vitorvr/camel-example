package com.camelexample.components;

import org.apache.camel.component.jms.JmsComponent;
import com.camelexample.connections.ArtemisConnection;

public class CamelArtemisComponent {

    public JmsComponent getArtemisComponent() {
        return JmsComponent.jmsComponent(new ArtemisConnection().getArtemisConnection());
    }
}

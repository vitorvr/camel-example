package com.camelexample.connections;

import javax.jms.ConnectionFactory;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;

public class ArtemisConnection {

    private ActiveMQJMSConnectionFactory connection;

    private InitialContext context;

    private String host;
    private String user;
    private String password;

    public ArtemisConnection() {
        try {
            context = new InitialContext();

            host = context.lookup("java:global/host").toString();
            user = context.lookup("java:global/user").toString();
            password = context.lookup("java:global/password").toString();

            connection = new ActiveMQJMSConnectionFactory(host, user, password);
            connection.setMinLargeMessageSize(10000000);

            context.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConnectionFactory getArtemisConnection() {
        return connection;
    }
}

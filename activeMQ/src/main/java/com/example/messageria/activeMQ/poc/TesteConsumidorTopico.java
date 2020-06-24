package com.example.messageria.activeMQ.poc;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class TesteConsumidorTopico {

	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		Connection connection = factory.createConnection();
		connection.setClientID("estoque");
		
		connection.start();
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		Topic topic = (Topic) context.lookup("loja");
		MessageConsumer consumer = session.createDurableSubscriber(topic, "assignature");
		
		consumer.setMessageListener(new Consumidor());
			
		
		new Scanner(System.in).nextLine();
		
		connection.close();
		context.close();

	}

}

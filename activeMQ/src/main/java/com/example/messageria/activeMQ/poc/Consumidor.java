package com.example.messageria.activeMQ.poc;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Consumidor implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("recebendo msg: " + textMessage.getText());
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}

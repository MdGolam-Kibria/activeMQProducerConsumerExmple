/*
package com.kibria.activeMqConsumer.controller;

import com.kibria.activeMqConsumer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageReceiver implements MessageListener
{
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message)
	{
		try
		{
			Student product = (Student) messageConverter.fromMessage(message);

			System.out.println("------- Inside onMessage-------");
			System.out.println(product);
			System.out.println("------- Inside onMessage-------");
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}

	}
}
*/

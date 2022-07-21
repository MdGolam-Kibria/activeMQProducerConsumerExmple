package com.kibria.activeMqConsumer.controller;

import com.kibria.activeMqConsumer.util.QueueUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @JmsListener(destination = QueueUtil.TEST_QUEUE)
    public void consumeMessage(String message) {
        LOGGER.info("Message received from activemq queue---" + message);
    }
}

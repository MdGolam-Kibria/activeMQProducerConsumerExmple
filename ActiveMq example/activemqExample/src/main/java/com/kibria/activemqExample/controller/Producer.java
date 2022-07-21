package com.kibria.activemqExample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kibria.activemqExample.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class Producer {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @PostMapping("/message")
    public Student sendMessage(@RequestBody Student student) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(student);
            LOGGER.info("Going to send message to activemq queue---"+studentAsJson);
            jmsTemplate.send(session -> session.createTextMessage(studentAsJson));
            LOGGER.info("Successfully Message sent to activemq queue---"+studentAsJson);
        } catch (Exception e) {
            LOGGER.info("Error in sending message to activemq queue---"+e.getMessage());
            e.printStackTrace();
        }
        return student;
    }

    @PostMapping("/customMessage")
    public Student sendMessageWithCustomQueue(@RequestBody Student student){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(student);
            LOGGER.info("Going to send message to customQueue1 queue message---"+studentAsJson);
            jmsTemplate.convertAndSend("customQueue1",studentAsJson);
            LOGGER.info("Successfully Message sent to customQueue1 queue---"+studentAsJson);
            LOGGER.info("Going to send message to customQueue2 queue message---"+studentAsJson);
            jmsTemplate.convertAndSend("customQueue2",studentAsJson);
            LOGGER.info("Successfully Message sent to customQueue2 queue---"+studentAsJson);
        } catch (Exception e) {
            LOGGER.info("Error in sending message to activemq queue---"+e.getMessage());
            e.printStackTrace();
        }
        return student;
    }



}

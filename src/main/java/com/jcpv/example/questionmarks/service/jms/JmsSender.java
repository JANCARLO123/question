package com.jcpv.example.questionmarks.service.jms;

import com.jcpv.example.questionmarks.model.Exam;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;
import javax.jms.Message;

import java.util.UUID;

import static com.jcpv.example.questionmarks.config.jms.JmsConfig.NAME_QUEUE;

/**
 * Created by jancarlo on 22/01/18.
 */

@Service
public class JmsSender {
    private static Logger log = LoggerFactory.getLogger(JmsConsumer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Exam exam) {
        log.info("sending with convertAndSend() to queue <" + exam + ">");
        jmsTemplate.convertAndSend(NAME_QUEUE, exam, m -> {

            log.info("setting standard JMS headers before sending");
            m.setJMSCorrelationID(UUID.randomUUID().toString());
            m.setJMSExpiration(1000);
            m.setJMSMessageID("message-id");
            m.setJMSDestination(new ActiveMQQueue(NAME_QUEUE));
            m.setJMSReplyTo(new ActiveMQQueue(NAME_QUEUE));
            m.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            m.setJMSPriority(Message.DEFAULT_PRIORITY);
            m.setJMSTimestamp(System.nanoTime());
            m.setJMSType("type");

            log.info("setting custom JMS headers before sending");
            m.setStringProperty("jms-custom-header", "this is a custom jms property");
            m.setBooleanProperty("jms-custom-property", true);
            m.setDoubleProperty("jms-custom-property-price", 0.0);

            return m;
        });
    }

    public void send(String destination, Object message) {
        log.info("sending2 with convertAndSend() to queue <" + message + ">");
        jmsTemplate.convertAndSend(destination, message, m -> {
            log.info("setting standard JMS headers before sending");
            m.setJMSCorrelationID(UUID.randomUUID().toString());
            m.setJMSExpiration(100);
            m.setJMSMessageID("message-id");
            m.setJMSDestination(new ActiveMQQueue(NAME_QUEUE));
            m.setJMSReplyTo(new ActiveMQQueue(NAME_QUEUE));
            m.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            m.setJMSPriority(Message.DEFAULT_PRIORITY);
            m.setJMSTimestamp(System.nanoTime());
            m.setJMSType("type");


            m.setStringProperty("jms-custom-header", "this is a custom jms property");
            m.setBooleanProperty("jms-custom-property", true);
            m.setDoubleProperty("jms-custom-property-price", 0.0);

            return m;
        });



    }
}

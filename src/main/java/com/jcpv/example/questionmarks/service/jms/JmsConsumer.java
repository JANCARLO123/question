package com.jcpv.example.questionmarks.service.jms;

import com.jcpv.example.questionmarks.model.Exam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.Message;
import java.util.concurrent.CountDownLatch;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import static com.jcpv.example.questionmarks.config.jms.JmsConfig.NAME_QUEUE;
import static com.jcpv.example.questionmarks.config.jms.JmsConfig.NAME_QUEUE2;
import javax.jms.Session;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jancarlo on 22/01/18.
 */

@Component
public class JmsConsumer {

    private static Logger log = LoggerFactory.getLogger(JmsConsumer.class);
    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }
    @JmsListener(destination = NAME_QUEUE)
    public void receiveMessage(@Payload Exam exam,
                               @Header(JmsHeaders.CORRELATION_ID) String correlationId,
                               @Header(name = "jms-header-not-exists", defaultValue = "default") String nonExistingHeader,
                               @Headers Map<String, Object> headers,
                               MessageHeaders messageHeaders,
                               JmsMessageHeaderAccessor jmsMessageHeaderAccessor) {

        log.info("received <" + exam + ">");

        log.info("\n# Spring JMS accessing single header property");
        log.info("- jms_correlationId=" + correlationId);
        log.info("- jms-header-not-exists=" + nonExistingHeader);

        log.info("\n# Spring JMS retrieving all header properties using Map<String, Object>");
        log.info("- jms-custom-header=" + String.valueOf(headers.get("jms-custom-header")));

        log.info("\n# Spring JMS retrieving all header properties using Map<String, Object>");
        log.info("- jms-custom-header=" + String.valueOf(headers.get("jms-custom-property")));

        log.info("\n# Spring JMS retrieving all header properties MessageHeaders");
        log.info("- jms-custom-property-price=" + messageHeaders.get("jms-custom-property-price", Double.class));

        log.info("\n# Spring JMS retrieving all header properties JmsMessageHeaderAccessor");
        log.info("- jms_destination=" + jmsMessageHeaderAccessor.getDestination());
        log.info("- jms_priority=" + jmsMessageHeaderAccessor.getPriority());
        log.info("- jms_timestamp=" + jmsMessageHeaderAccessor.getTimestamp());
        log.info("- jms_type=" + jmsMessageHeaderAccessor.getType());
        log.info("- jms_redelivered=" + jmsMessageHeaderAccessor.getRedelivered());
        log.info("- jms_replyTo=" + jmsMessageHeaderAccessor.getReplyTo());
        log.info("- jms_correlationId=" + jmsMessageHeaderAccessor.getCorrelationId());
        log.info("- jms_contentType=" + jmsMessageHeaderAccessor.getContentType());
        log.info("- jms_expiration=" + jmsMessageHeaderAccessor.getExpiration());
        log.info("- jms_messageId=" + jmsMessageHeaderAccessor.getMessageId());
        log.info("- jms_deliveryMode=" + jmsMessageHeaderAccessor.getDeliveryMode() + "\n");
    }

    @JmsListener(destination = NAME_QUEUE2)
    public void receiveMessage2(@Payload Object object,
                               @Header(JmsHeaders.CORRELATION_ID) String correlationId,
                               @Header(name = "jms-header-not-exists", defaultValue = "default") String nonExistingHeader,
                               @Headers Map<String, Object> headers,
                               MessageHeaders messageHeaders,
                               JmsMessageHeaderAccessor jmsMessageHeaderAccessor) {


        log.info("received2 <" + object + ">");

        log.info("\n# Spring JMS accessing single header property");
        log.info("- jms_correlationId=" + correlationId);
        log.info("- jms-header-not-exists=" + nonExistingHeader);

        log.info("\n# Spring JMS retrieving all header properties using Map<String, Object>");
        log.info("- jms-custom-header=" + String.valueOf(headers.get("jms-custom-header")));

        log.info("\n# Spring JMS retrieving all header properties using Map<String, Object>");
        log.info("- jms-custom-header=" + String.valueOf(headers.get("jms-custom-property")));

        log.info("\n# Spring JMS retrieving all header properties MessageHeaders");
        log.info("- jms-custom-property-price=" + messageHeaders.get("jms-custom-property-price", Double.class));

        log.info("\n# Spring JMS retrieving all header properties JmsMessageHeaderAccessor");
        log.info("- jms_destination=" + jmsMessageHeaderAccessor.getDestination());
        log.info("- jms_priority=" + jmsMessageHeaderAccessor.getPriority());
        log.info("- jms_timestamp=" + jmsMessageHeaderAccessor.getTimestamp());
        log.info("- jms_type=" + jmsMessageHeaderAccessor.getType());
        log.info("- jms_redelivered=" + jmsMessageHeaderAccessor.getRedelivered());
        log.info("- jms_replyTo=" + jmsMessageHeaderAccessor.getReplyTo());
        log.info("- jms_correlationId=" + jmsMessageHeaderAccessor.getCorrelationId());
        log.info("- jms_contentType=" + jmsMessageHeaderAccessor.getContentType());
        log.info("- jms_expiration=" + jmsMessageHeaderAccessor.getExpiration());
        log.info("- jms_messageId=" + jmsMessageHeaderAccessor.getMessageId());
        log.info("- jms_deliveryMode=" + jmsMessageHeaderAccessor.getDeliveryMode() + "\n");
    }
}

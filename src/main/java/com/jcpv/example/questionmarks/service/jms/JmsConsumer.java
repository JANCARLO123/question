package com.jcpv.example.questionmarks.service.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import static com.jcpv.example.questionmarks.config.jms.JmsConfig.NAME_QUEUE;

import javax.jms.Session;

/**
 * Created by jancarlo on 22/01/18.
 */
@Slf4j
@Component
public class JmsConsumer {

    @JmsListener(destination = NAME_QUEUE)
    public void receiveMessage(@Payload char exam,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("received <" + exam + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message);
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}

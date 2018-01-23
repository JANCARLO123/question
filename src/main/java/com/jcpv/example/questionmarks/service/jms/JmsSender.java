package com.jcpv.example.questionmarks.service.jms;

import com.jcpv.example.questionmarks.model.Exam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import static com.jcpv.example.questionmarks.config.jms.JmsConfig.NAME_QUEUE;

/**
 * Created by jancarlo on 22/01/18.
 */
@Slf4j
@Service
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Exam exam) {
        log.info("sending with convertAndSend() to queue <" + exam + ">");
        jmsTemplate.convertAndSend(NAME_QUEUE, exam);
    }
}

package com.langg.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author zh
 * @date 2019/11/8 17:23
 * @since 1.0.0
 */
@Component
@Slf4j
public class MqConsumer {

    @JmsListener(destination = "test.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String message) {
        log.debug("消费queue, message = {}", message);
    }

    @JmsListener(destination = "test.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic1(String message) {
        log.debug("消费者1消费topic, message = {}", message);
    }

    @JmsListener(destination = "test.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String message) {
        log.debug("消费者2消费topic, message = {}", message);
    }
}

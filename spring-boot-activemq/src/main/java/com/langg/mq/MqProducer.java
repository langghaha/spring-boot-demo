package com.langg.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 *
 * @author zh
 * @date 2019/11/8 17:16
 * @since 1.0.0
 */
@Component
@EnableScheduling
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class MqProducer {

    private final JmsMessagingTemplate jmsMessagingTemplate;

    private final ActiveMQQueue activeMQQueue;

    private final ActiveMQTopic activeMQTopic;

    /**
     * 每5秒发送一次
     */
    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void sendMessage() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "这是一条queue, time = " + System.currentTimeMillis());
        log.debug("生产者生产了一条queue");

        jmsMessagingTemplate.convertAndSend(activeMQTopic, "这是一条topic, time = " + System.currentTimeMillis());
        log.debug("生产者生产了一条topic");
    }
}

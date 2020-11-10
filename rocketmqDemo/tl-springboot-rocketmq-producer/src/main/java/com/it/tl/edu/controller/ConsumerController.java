package com.it.tl.edu.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：
 * @date：2019/11/6
 * @version: V1.0
 * @slogan:
 * @description :
 */
@RestController
public class ConsumerController {

    @Value("${tl.rocketmq.topic}")
    private String springTopic;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("consumer")
    public String index(){
        SendResult result = rocketMQTemplate.syncSend(springTopic,"发送消息");
        return "send_status:"+result.getSendStatus().name();
    }

}

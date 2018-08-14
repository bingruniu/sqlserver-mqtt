package com.hollysys.hiadsp.mqtt;

import com.hollysys.hiadsp.base.Consts;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendToMqtt {

    private static Logger logger = LoggerFactory.getLogger(SentResToMqtt.class);
    private static MqttClient mqttClient = ClientMqtt.getClient();
    private static MqttTopic topicmqtt = mqttClient.getTopic(Consts.kMqttTopicTsName);
    private static MqttMessage message = new MqttMessage();

    static {
        message.setQos(1);
        message.setRetained(true);
    }
    public void sendRes(String str) {

        message.setPayload(str.getBytes());
        try {
            MqttDeliveryToken token =topicmqtt.publish(message);
        } catch (MqttException e) {
            logger.error("没写进去，等待1s后重写： "+ str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                topicmqtt.publish(message);
            } catch (MqttException e1) {
                logger.error("还是没写进去！等待2s后再写一次");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e2) {
                    e1.printStackTrace();
                }
                try {
                    topicmqtt.publish(message);
                } catch (MqttException e3) {
                    logger.error("写不进去了，算了！");
                }
            }

        }
    }
}

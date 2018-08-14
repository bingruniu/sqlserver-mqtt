package com.hollysys.hiadsp.mqtt;

import com.hollysys.hiadsp.base.Consts;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentResToMqtt {

    private static Logger logger = LoggerFactory.getLogger(SentResToMqtt.class);
    private MqttClient mqttClient;

    public void sendRes(String str) {
        mqttClient = ClientMqtt.getClient();
        MqttTopic topicmqtt = mqttClient.getTopic(Consts.kMqttTopicTsName);

        MqttMessage message = new MqttMessage();
        message.setQos(1);
        message.setRetained(true);

        message.setPayload(str.getBytes());
        MqttDeliveryToken token = null;
        try {
            token = topicmqtt.publish(message);
            System.out.println("发送成功！" + token);
        } catch (MqttException e) {
            logger.error("", e);
        }
    }


    public static void main(String[] args) {
        ClientMqtt c = new ClientMqtt();
        c.start();
        SentResToMqtt send = new SentResToMqtt();
        for (int i = 1; i < 5; i++) {
            String mess = "clustertest";

            send.sendRes(mess);
        }

    }
}

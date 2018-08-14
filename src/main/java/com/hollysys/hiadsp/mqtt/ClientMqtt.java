package com.hollysys.hiadsp.mqtt;

import com.hollysys.hiadsp.base.Consts;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMqtt {

    public static final Logger logger = LoggerFactory.getLogger(ClientMqtt.class);
    public static final String HOST = Consts.kClientMqttHostName;
    private static final String clientid = Consts.kClientMqttClientId;
    private String userName = Consts.kClientMqttUser;
    private String passWord = Consts.kClientMqttPassword;

    private static MqttClient client;
    private MqttConnectOptions options;


    public void start() {
        try {
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            options.setAutomaticReconnect(true);
            buildClient(clientid, options);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MqttClient getClient() {
        return client;
    }

    public static void buildClient(String clientId, MqttConnectOptions options) {
        try {

            client = null;
            client = new MqttClient(HOST, clientId, new MemoryPersistence());
            // 设置回调
           // client.setCallback(new PushCallback(client, options));
            client.connect(options);

        } catch (MqttException e) {
            logger.error("build client stopped due to " + e.getCause());
        }

    }


    /*public static void main(String[] args) {
        ConfigManager.init();
        ClientMqtt clientMqtt = new ClientMqtt();
        clientMqtt.start();
    }*/


}
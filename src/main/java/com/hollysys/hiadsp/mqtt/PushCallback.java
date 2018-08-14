package com.hollysys.hiadsp.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.hollysys.hiadsp.base.Consts;
import com.hollysys.hiadsp.util.MessQueue;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 发布消息的回调类
 * <p>
 * 必须实现MqttCallback的接口并实现对应的相关接口方法CallBack 类将实现 MqttCallBack。
 * 每个客户机标识都需要一个回调实例。在此示例中，构造函数传递客户机标识以另存为实例数据。 在回调中，将它用来标识已经启动了该回调的哪个实例。
 * 必须在回调类中实现三个方法：
 * <p>
 * public void messageArrived(MqttTopic topic, MqttMessage message)接收已经预订的发布。
 * <p>
 * public void connectionLost(Throwable cause)在断开连接时调用。
 * <p>
 * public void deliveryComplete(MqttDeliveryToken token)) 接收到已经发布的 QoS 1 或 QoS 2
 * 消息的传递令牌时调用。 由 MqttClient.connect 激活此回调。
 */
public class PushCallback implements MqttCallback {

    private static Logger logger = LoggerFactory.getLogger(PushCallback.class);
    private MqttClient client;
    private MqttConnectOptions options;
    private static String tsTopic = Consts.kMqttTopicTsName.replace("+", "");

    private static Map<String, String> topicToTenantId = Maps.newHashMap();
    private static MqttTsEntity tsEntity = new MqttTsEntity();
    private static MqttTsEntity alarmEntity = new MqttTsEntity();
    private static ObjectMapper mapper = new ObjectMapper();


    public PushCallback(MqttClient client, MqttConnectOptions options) {
        this.client = client;
        this.options = options;
    }

    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        logger.error("connect lost " + cause.getMessage());
        if (!client.isConnected()) {

//			logger.info("客户端进行重连 clientid: " + Consts.kClientMqttClientId);
//			ClientMqtt.buildClient(Consts.kClientMqttClientId, options);
        }
        if (client.isConnected()) {
            logger.info("重连成功！");
        }

    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        //System.out.println("deliveryComplete---------" + token.isComplete());
    }

    public void messageArrived(String topic, MqttMessage message) {
        message.setRetained(true);
        // subscribe后得到的消息会执行到这里面
        String messStr = new String(message.getPayload());
//		System.out.println("接收消息主题 : " + topic);
//		System.out.println("接收消息Qos : " + message.getQos());
//		System.out.println("接收消息内容 : " + messStr);
        String tenantId = topicToTenantId.get(topic);
        if (null == tenantId) {
            if (topic.contains("/")) {
                tenantId = topic.split("/")[0];

            } else {
                tenantId = "000000";
            }
            topicToTenantId.put(topic, tenantId);
        }


//		 处理接收到的数据
        if (null != messStr) {
            if (topic.contains(tsTopic)) {
                try {
                    tsEntity.setTenantId(tenantId);
                    tsEntity.setMess(messStr);
//					System.out.println("put进队列的数据：" + messStr);
                    String queueMess = null;
                    try {
                        queueMess = mapper.writeValueAsString(tsEntity);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    MessQueue.mqttMessTsQueue.put(queueMess);
//					logger.info("时序数据put入队列！");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    logger.error("put queue fail!" + e);
                }
            }

        }

    }
}
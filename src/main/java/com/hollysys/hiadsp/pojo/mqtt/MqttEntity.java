package com.hollysys.hiadsp.pojo.mqtt;

import java.util.Map;

/**
 * @author wujingjing
 * 2017-10-11
 * mqtt接收到的数据
 */
public class MqttEntity {

    private Map<String, String> property;
    private MqttTsMess message;

    public Map<String, String> getProperty() {
        return property;
    }

    public void setProperty(Map<String, String> property) {
        this.property = property;
    }

    public MqttTsMess getMessage() {
        return message;
    }

    public void setMessage(MqttTsMess message) {
        this.message = message;
    }


}

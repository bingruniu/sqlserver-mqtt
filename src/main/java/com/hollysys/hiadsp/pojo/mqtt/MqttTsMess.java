package com.hollysys.hiadsp.pojo.mqtt;

import java.util.List;

public class MqttTsMess {

    private String namespace /*= "ahdldvpt"*/;      //安徽电力代维平台
    private List<MqttValues> values;
    private Boolean current /*= true*/;             //默认 true
    private Boolean history /*= true*/;             //默认 true


    public MqttTsMess(){}

    public MqttTsMess(String namespace, List<MqttValues> values, Boolean current, Boolean history){
        this.namespace = namespace;
        this.values = values;
        this.current = current;
        this.history = history;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public List<MqttValues> getValues() {
        return values;
    }

    public void setValues(List<MqttValues> values) {
        this.values = values;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Boolean getHistory() {
        return history;
    }

    public void setHistory(Boolean history) {
        this.history = history;
    }


}

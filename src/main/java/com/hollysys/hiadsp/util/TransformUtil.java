package com.hollysys.hiadsp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollysys.hiadsp.pojo.TransformerEntity;
import com.hollysys.hiadsp.pojo.mqtt.MqttEntity;
import com.hollysys.hiadsp.pojo.mqtt.MqttTsMess;
import com.hollysys.hiadsp.pojo.mqtt.MqttValues;

import java.util.ArrayList;
import java.util.List;

public class TransformUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 转换sql读取到的历史数据为mqtt格式数据
     *
     * @param entity
     * @return
     */
    public static MqttEntity trans(TransformerEntity entity, int i) {
        MqttEntity mqttEntity = new MqttEntity();
        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();
        switch (i){
            case 1:
                mqttValuesList = buildValues(entity);
                break;
            case 2:
                mqttValuesList = buildValues2(entity);
                break;
            case 3:
                mqttValuesList = buildValues3(entity);
                break;
            case 4:
                mqttValuesList = buildValues4(entity);
                break;
            case 5:
                mqttValuesList = buildValues5(entity);
                break;
        }


        MqttTsMess mess = new MqttTsMess("ahdldwpt", mqttValuesList, true, true);

        mqttEntity.setMessage(mess);

        try {
            FileUtil.writeToFile("e://project-test/transformer", mapper.writeValueAsString(mqttEntity));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mqttEntity;
    }

    private static List<MqttValues> buildValues(TransformerEntity entity) {

        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();

        mqttValuesList.add(new MqttValues("1-1AA1_Uab", new MqttValues.Value(entity.getV001(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_Ubc", new MqttValues.Value(entity.getV002(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_Uca", new MqttValues.Value(entity.getV003(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_Ulavg", new MqttValues.Value(entity.getV004(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_MIa", new MqttValues.Value(entity.getV005(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_MIb", new MqttValues.Value(entity.getV006(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-1AA1_MIc", new MqttValues.Value(entity.getV007(), 1l, entity.getTIMEID())));

        return mqttValuesList;
    }

    private static List<MqttValues> buildValues2(TransformerEntity entity) {

        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();

        mqttValuesList.add(new MqttValues("1-2AA1_Uab", new MqttValues.Value(entity.getV001(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_Ubc", new MqttValues.Value(entity.getV002(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_Uca", new MqttValues.Value(entity.getV003(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_Ulavg", new MqttValues.Value(entity.getV004(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_MIa", new MqttValues.Value(entity.getV005(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_MIb", new MqttValues.Value(entity.getV006(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-2AA1_MIc", new MqttValues.Value(entity.getV007(), 1l, entity.getTIMEID())));

        return mqttValuesList;
    }

    private static List<MqttValues> buildValues3(TransformerEntity entity) {

        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();

        mqttValuesList.add(new MqttValues("1-3AA1_Uab", new MqttValues.Value(entity.getV001(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_Ubc", new MqttValues.Value(entity.getV002(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_Uca", new MqttValues.Value(entity.getV003(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_Ulavg", new MqttValues.Value(entity.getV004(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_MIa", new MqttValues.Value(entity.getV005(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_MIb", new MqttValues.Value(entity.getV006(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-3AA1_MIc", new MqttValues.Value(entity.getV007(), 1l, entity.getTIMEID())));

        return mqttValuesList;
    }

    private static List<MqttValues> buildValues4(TransformerEntity entity) {

        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();

        mqttValuesList.add(new MqttValues("1-4AA1_Uab", new MqttValues.Value(entity.getV001(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_Ubc", new MqttValues.Value(entity.getV002(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_Uca", new MqttValues.Value(entity.getV003(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_Ulavg", new MqttValues.Value(entity.getV004(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_MIa", new MqttValues.Value(entity.getV005(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_MIb", new MqttValues.Value(entity.getV006(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-4AA1_MIc", new MqttValues.Value(entity.getV007(), 1l, entity.getTIMEID())));

        return mqttValuesList;
    }

    private static List<MqttValues> buildValues5(TransformerEntity entity) {

        List<MqttValues> mqttValuesList = new ArrayList<MqttValues>();

        mqttValuesList.add(new MqttValues("1-5AA1_Uab", new MqttValues.Value(entity.getV001(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_Ubc", new MqttValues.Value(entity.getV002(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_Uca", new MqttValues.Value(entity.getV003(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_Ulavg", new MqttValues.Value(entity.getV004(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_MIa", new MqttValues.Value(entity.getV005(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_MIb", new MqttValues.Value(entity.getV006(), 1l, entity.getTIMEID())));
        mqttValuesList.add(new MqttValues("1-5AA1_MIc", new MqttValues.Value(entity.getV007(), 1l, entity.getTIMEID())));

        return mqttValuesList;
    }
}

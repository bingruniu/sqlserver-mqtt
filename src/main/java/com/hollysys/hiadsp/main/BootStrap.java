package com.hollysys.hiadsp.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollysys.hiadsp.base.Consts;
import com.hollysys.hiadsp.init.ConfigManager;
import com.hollysys.hiadsp.mapper.TransformerMapper;
import com.hollysys.hiadsp.mqtt.ClientMqtt;
import com.hollysys.hiadsp.pojo.TransformerEntity;
import com.hollysys.hiadsp.pojo.mqtt.MqttEntity;
import com.hollysys.hiadsp.util.DBTools;
import com.hollysys.hiadsp.util.FileUtil;
import com.hollysys.hiadsp.util.MessQueue;
import com.hollysys.hiadsp.util.TransformUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BootStrap {

    private static ObjectMapper MAPPER = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(BootStrap.class);

    public static void main(String[] args) {
        ConfigManager.init();

        ClientMqtt clientMqtt = new ClientMqtt();
        clientMqtt.start();

        MqttPublisher processMess = new MqttPublisher();
        processMess.start();

        //读取关系数据
        selectTransformers();
    }

    private static void selectTransformers() {
        SqlSession session = DBTools.getSession();
        TransformerMapper mapper = session.getMapper(TransformerMapper.class);
        //String resultStr = null;
        try {
            List<TransformerEntity> transformerList = mapper.selectTransformers();
            logger.info("变压器1 数据量： " + transformerList.size());
            List<TransformerEntity> transformerList2 = mapper.selectTransformers2();
            logger.info("变压器2 数据量： " + transformerList2.size());
            List<TransformerEntity> transformerList3 = mapper.selectTransformers3();
            logger.info("变压器3 数据量： " + transformerList3.size());
            List<TransformerEntity> transformerList4 = mapper.selectTransformers4();
            logger.info("变压器4 数据量： " + transformerList4.size());
            List<TransformerEntity> transformerList5 = mapper.selectTransformers5();
            logger.info("变压器5 数据量： " + transformerList5.size());
            //resultStr = MAPPER.writeValueAsString(transformerList);
            session.commit();
            for (TransformerEntity key : transformerList) {
                MqttEntity entity = TransformUtil.trans(key, 1);
                String value = MAPPER.writeValueAsString(entity);
                //MessQueue.mqttMessTsQueue.put(value);
                FileUtil.writeToFile(Consts.kTrans1FilePath1, value);
            }
            for (TransformerEntity key : transformerList2) {
                MqttEntity entity = TransformUtil.trans(key, 2);
                String value = MAPPER.writeValueAsString(entity);
                MessQueue.mqttMessTsQueue.put(value);
                FileUtil.writeToFile(Consts.kTrans1FilePath2, value);
            }
            for (TransformerEntity key : transformerList3) {
                MqttEntity entity = TransformUtil.trans(key, 3);
                String value = MAPPER.writeValueAsString(entity);
                MessQueue.mqttMessTsQueue.put(value);
                FileUtil.writeToFile(Consts.kTrans1FilePath3, value);
            }
            for (TransformerEntity key : transformerList4) {
                MqttEntity entity = TransformUtil.trans(key, 4);
                String value = MAPPER.writeValueAsString(entity);
                MessQueue.mqttMessTsQueue.put(value);
                FileUtil.writeToFile(Consts.kTrans1FilePath4, value);
            }
            for (TransformerEntity key : transformerList5) {
                MqttEntity entity = TransformUtil.trans(key, 5);
                String value = MAPPER.writeValueAsString(entity);
                MessQueue.mqttMessTsQueue.put(value);
                FileUtil.writeToFile(Consts.kTrans1FilePath5, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

    }
}

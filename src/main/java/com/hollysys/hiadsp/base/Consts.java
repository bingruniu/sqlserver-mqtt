package com.hollysys.hiadsp.base;


import com.hollysys.hiadsp.init.ConfigManager;
import com.typesafe.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Consts {

    private Consts() {
    }

    private static final Logger logger = LoggerFactory.getLogger(Consts.class);

    private static Config conf = null;

    static {
        ConfigManager.init();
        conf = ConfigManager.getConfig();
    }

    private static String getString(String key) {
        try {
            return conf.getString(key);
        } catch (Exception e) {
            logger.error("Read key={} failed! System exit!", key);
            logger.error(e.getMessage(), e);
            System.exit(0);
        }
        return null;
    }


    private static int getInt(String key) {
        try {
            return conf.getInt(key);
        } catch (Exception e) {
            logger.error("Read key={} failed! System exit!", key);
            logger.error(e.getMessage(), e);
            System.exit(0);
        }
        return 0;
    }


    private static boolean getBoolean(String key) {
        try {
            return conf.getBoolean(key);
        } catch (Exception e) {
            logger.error("Read key={} failed! System exit!", key);
            logger.error(e.getMessage(), e);
            System.exit(0);
        }
        return false;
    }

    //mqtt client配置
    public static final String kClientMqttHostName = getString("mqtt.client.hostname");
    public static final String kMqttTopicTsName = getString("mqtt.client.topicTs");

    public static final String kClientMqttUser = getString("mqtt.client.username");
    public static final String kClientMqttPassword = getString("mqtt.client.password");


    // 读取clientid
    public static final String kClientMqttClientId = getString("mqtt.client.clientid");

    public static final String kTrans1FilePath1 = getString("file.trans1");
    public static final String kTrans1FilePath2 = getString("file.trans2");
    public static final String kTrans1FilePath3 = getString("file.trans3");
    public static final String kTrans1FilePath4 = getString("file.trans4");
    public static final String kTrans1FilePath5 = getString("file.trans5");


}

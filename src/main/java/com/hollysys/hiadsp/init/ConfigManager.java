package com.hollysys.hiadsp.init;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigManager {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigManager.class);
    // 配置文件的URL环境变量名
    private static final String kEnvName4ConfigUrl = "TSC_CONF_URL";
    private static Config conf = null;
    private static Object lock = new Object();
    private static boolean initialized = false;

    public static boolean init() {
        if (!initialized) {
            synchronized (lock) {
                if (!initialized) {

                    conf = ConfigFactory.load();
                    initialized = true;
                }
            }
        }

        return initialized;
    }

    public static Config getConfig() {
        if (!initialized) {
            throw new RuntimeException("ConfigReader not initialized. Please call init first!!!");
        }
        return conf;
    }

}

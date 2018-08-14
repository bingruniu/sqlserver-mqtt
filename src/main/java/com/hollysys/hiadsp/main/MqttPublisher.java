package com.hollysys.hiadsp.main;

import com.hollysys.hiadsp.mqtt.SendToMqtt;
import com.hollysys.hiadsp.util.MessQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttPublisher extends Thread {

    private static Logger logger = LoggerFactory.getLogger(MqttPublisher.class);
    static SendToMqtt sentResToMqtt = new SendToMqtt();
    public void run() {

        System.out.println("write to mqtt running");
        int i = 1;
        long start = 0L;
        long end;

        for (; ; ) {
            try {
                String queueMess = MessQueue.mqttMessTsQueue.take();
                Thread.sleep(100);
                try{
                    sentResToMqtt.sendRes(queueMess);
                }catch (Exception e){
                    logger.error("没写进去，重写"+ queueMess);
                    Thread.sleep(150);
                    sentResToMqtt.sendRes(queueMess);
                }

                if (i == 1) {
                    start = System.currentTimeMillis();
                } else if (i == 100) {
                    end = System.currentTimeMillis();
                    logger.info("size :" + MessQueue.mqttMessTsQueue.size() + "  write to mqtt  100 Take: " + (end - start) / 1000.0
                            + " seconds.");

                    i = 0;
                }
                i++;
            } catch (InterruptedException e) {
                logger.error("mqtt publish faild: ",e);
            }



        }
    }

}

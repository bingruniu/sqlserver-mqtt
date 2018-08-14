package com.hollysys.hiadsp.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessQueue {

    public static BlockingQueue<String> mqttMessTsQueue = new LinkedBlockingQueue<String>(50000);


}

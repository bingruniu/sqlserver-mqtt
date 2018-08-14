package com.hollysys.hiadsp.pojo.mqtt;

/**
 * "id": <string>,
 * "value": {
 * "v": <Any>,bool, int, double, string，long
 * "s": 0x00000000|0x40000000|0x80000000,
 * "t": <uint64>,(时间)
 * "st": <uint64>(时间) //去掉了
 * }
 */
public class MqttValues {

    private String id;
    private Value value;

    public MqttValues(){}

    public MqttValues(String id, Value value){
        this.id = id;
        this.value = value;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Value getValue() {
        return value;
    }


    public void setValue(Value value) {
        this.value = value;
    }


    public static class Value {

        private Object v;
        private Object s;
        private Object t;

        public Value(){}

        public Value(Object v, Object s, Object t){
            this.v = v;
            this.s = s;
            this.t = t;
        }

        //		private Object st;
        public Object getV() {
            return v;
        }

        public void setV(Object v) {
            this.v = v;
        }

        public Object getS() {
            return s;
        }

        public void setS(Object s) {
            this.s = s;
        }

        public Object getT() {
            return t;
        }

        public void setT(Object t) {
            this.t = t;
        }
    }

}

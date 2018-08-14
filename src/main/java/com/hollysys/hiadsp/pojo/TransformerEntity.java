package com.hollysys.hiadsp.pojo;

import java.util.Date;

/**
 * 变压器
 */
public class TransformerEntity {
    private Date TIMEID;
    private double V001;
    private double V002;
    private double V003;
    private double V004;
    private double V005;
    private double V006;
    private double V007;

    public TransformerEntity() {
    }

    public TransformerEntity(Date TIMEID, double V001, double V002, double V003, double V004, double V005, double V006, double V007) {
        this.TIMEID = TIMEID;
        this.V001 = V001;
        this.V002 = V002;
        this.V003 = V003;
        this.V004 = V004;
        this.V005 = V005;
        this.V006 = V006;
        this.V007 = V007;
    }

    public Date getTIMEID() {
        return TIMEID;
    }

    public void setTIMEID(Date TIMEID) {
        this.TIMEID = TIMEID;
    }

    public double getV001() {
        return V001;
    }

    public void setV001(double v001) {
        V001 = v001;
    }

    public double getV002() {
        return V002;
    }

    public void setV002(double v002) {
        V002 = v002;
    }

    public double getV003() {
        return V003;
    }

    public void setV003(double v003) {
        V003 = v003;
    }

    public double getV004() {
        return V004;
    }

    public void setV004(double v004) {
        V004 = v004;
    }

    public double getV005() {
        return V005;
    }

    public void setV005(double v005) {
        V005 = v005;
    }

    public double getV006() {
        return V006;
    }

    public void setV006(double v006) {
        V006 = v006;
    }

    public double getV007() {
        return V007;
    }

    public void setV007(double v007) {
        V007 = v007;
    }
}

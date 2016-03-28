package com.kylin.afinaldemo.bean;

import java.io.Serializable;

/**
 * Created by Kylin on 2016/3/18.
 * <p/>
 * "status": "ok",
 * "paramz":
 */
public class AppBean implements Serializable {

    private String status;
    private ParamzBean paramz;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParamzBean getParamz() {
        return paramz;
    }

    public void setParamz(ParamzBean paramz) {
        this.paramz = paramz;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "status='" + status + '\'' +
                ", paramz=" + paramz +
                '}';
    }
}

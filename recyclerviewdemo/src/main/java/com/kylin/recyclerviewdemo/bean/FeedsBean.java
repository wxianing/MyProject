package com.kylin.recyclerviewdemo.bean;

import java.io.Serializable;

/**
 * Created by Kylin on 2016/3/18.
 * "id": 298865,
 * "oid": 288189,
 * "category": "article",
 * "data":
 */
public class FeedsBean implements Serializable {
    private String id;
    private String oid;
    private String category;

    private DataBean data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FeedsBean{" +
                "id='" + id + '\'' +
                ", oid='" + oid + '\'' +
                ", category='" + category + '\'' +
                ", data=" + data +
                '}';
    }
}

package com.kylin.afinaldemo.bean;

import java.io.Serializable;

/**
 * Created by Kylin on 2016/3/18.
 * "subject": "巴萨名将：梅西比C罗更出色",
 * "summary": "巴萨巴萨名将表示，巴萨的进攻三叉戟MSN组合比皇马的BBC组合更加出色。",
 * "cover": "/Attachs/Article/288268/f2c2727de9924fceb473009831a4e871_padmini.JPG",
 * "pic": "",
 * "format": "txt",
 * "changed": "2015-09-19 15:38:11"
 */
public class DataBean implements Serializable {

    private String subject;
    private String summary;
    private String cover;
    private String pic;
    private String format;
    private String changed;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "subject='" + subject + '\'' +
                ", summary='" + summary + '\'' +
                ", cover='" + cover + '\'' +
                ", pic='" + pic + '\'' +
                ", format='" + format + '\'' +
                ", changed='" + changed + '\'' +
                '}';
    }
}

package com.moon.moonchat.entity;

import java.util.Date;

/**
 * 消息格式
 * create by ChenKaiBin on 2019/3/12
 */
public class Message {

    private String src;     //发送者id

    private String dest;    //目的者id

    private String srcName;     //发送者nickname

    private String msg;     //消息内容

    private String time;      //服务端发送时间

    public Message(String src, String dest, String srcName, String msg, String time) {
        this.src = src;
        this.dest = dest;
        this.srcName = srcName;
        this.msg = msg;
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", srcName='" + srcName + '\'' +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                '}';
    }
}

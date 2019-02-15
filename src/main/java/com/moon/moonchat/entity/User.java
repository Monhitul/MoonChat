package com.moon.moonchat.entity;

/**
 *  用户类
 */
public class User {
    private String uid; //账号
    private String password;
    private String nickname;    //昵称
    private String avatar;  //头像
    private String sex;
    private String createDate;  //创建日期
    private String lastTime;    //上次登录时间
    private boolean deleted;    //是否删除

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

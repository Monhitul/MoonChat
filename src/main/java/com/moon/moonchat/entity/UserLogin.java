package com.moon.moonchat.entity;

/**
 *
 */
public class UserLogin {
    private String uid;
    private String password;

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

    @Override
    public String toString() {
        return "UserLogin{" +
                "uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

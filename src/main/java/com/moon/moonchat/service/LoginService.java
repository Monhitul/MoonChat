package com.moon.moonchat.service;

import com.moon.moonchat.entity.User;

import java.util.List;

/**
 *  为登录注册服务的service接口
 */
public interface LoginService {
    User checkLogin(User user);

    boolean addUser(User user); //用于注册

    boolean removeUser(String uid);

    boolean modifyUser(User user);

    User findFriend(String uid);

    List<User> findFriends(String uid);
}

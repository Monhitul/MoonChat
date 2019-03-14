package com.moon.moonchat.service.Impl;

import com.moon.moonchat.dao.UserDao;
import com.moon.moonchat.entity.User;
import com.moon.moonchat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  实现LoginService接口
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    //用于验证登录
    @Override
    public User checkLogin(User user) {
        User res = userDao.selectUser(user);
        return res;
    }

    //用于注册
    @Override
    public boolean addUser(User user) {
        int res = userDao.saveUser(user);
        return (res>0);
    }

    @Override
    public boolean removeUser(String uid) {
        return false;
    }

    @Override
    public boolean modifyUser(User user) {
        return false;
    }

    @Override
    public User findFriend(String uid) {
        return null;
    }

    @Override
    public List<User> findFriends(String uid) {
        return null;
    }

    @Override
    public boolean checkUid(String uid) {
        User res = userDao.findUid(uid);
        return (res != null);
    }
}

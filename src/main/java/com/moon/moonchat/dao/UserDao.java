package com.moon.moonchat.dao;

import com.moon.moonchat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  用户数据库操作接口
 */
@Component
@Mapper
public interface UserDao {
    User selectUser(User user); //用于用户登录查询账号密码是否符合

    int saveUser(User user);    //用于注册

    int deleteUser(String uid);

    int updateUser(User user);  //用于增加或修改用户信息，如nickname等

    User selectFriend(String uid);    //用于查找好友

    List<User> selectFriends(String uid); //用于查询好友列表，需要另外一个表
}

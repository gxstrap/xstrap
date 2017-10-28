package com.xuebusi.service;

import com.xuebusi.entity.User;
import java.util.List;

/**
 * 用户基本信息
 * Created by SYJ on 2017/10/15.
 */
public interface UserService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findOne(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 保存个人设置信息
     * @param user
     * @return
     */
    User save(User user);
}

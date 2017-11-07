package com.xuebusi.repository;

import com.xuebusi.entity.WeiboUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 微博授权信息
 * @author caiyuyu
 * @date 2017/11/2
 */

public interface WeiboUserRepository extends JpaRepository<WeiboUser, String> {

    /**
     * 根据用户名查询是否存在微博绑定
     * @param username
     * @param state
     * @return
     */
    WeiboUser findByUsernameAndState(String username, Integer state);

    /**
     * 根据微博id查询
     * @param id
     * @param state
     * @return
     */
    WeiboUser findByWeiboIdAndState(String id, Integer state);
}

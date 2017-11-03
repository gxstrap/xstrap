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
     * 根据token查询微博信息
     * @param token
     * @return
     */
    WeiboUser findByAccessToken(String token);
}

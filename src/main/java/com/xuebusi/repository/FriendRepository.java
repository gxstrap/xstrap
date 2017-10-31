package com.xuebusi.repository;

import com.xuebusi.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 关注/粉丝
 * Created by SYJ on 2017/10/30.
 */
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    /**
     * 查询粉丝列表
     * @param fromId
     * @return
     */
    List<Friend> findByFromId(Integer fromId);

    /**
     * 查询关注人列表
     * @param toId
     * @return
     */
    List<Friend> findByToId(Integer toId);
}

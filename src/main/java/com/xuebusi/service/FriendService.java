package com.xuebusi.service;

import com.xuebusi.entity.Friend;
import com.xuebusi.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关注/粉丝
 * Created by SYJ on 2017/10/30.
 */
@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    /**
     * 查询粉丝列表
     * @param fromId
     * @return
     */
    public List<Friend> findByFromId(Integer fromId) {
        return friendRepository.findByFromId(fromId);
    }

    /**
     * 查询关注人列表
     * @param toId
     * @return
     */
    public List<Friend> findByToId(Integer toId) {
        return friendRepository.findByToId(toId);
    }
}

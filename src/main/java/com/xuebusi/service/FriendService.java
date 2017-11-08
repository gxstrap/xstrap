package com.xuebusi.service;

import com.xuebusi.entity.Friend;
import com.xuebusi.repository.FriendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关注/粉丝
 * Created by SYJ on 2017/10/30.
 */
@Service
public class FriendService {

    protected final Logger log = LoggerFactory.getLogger(getClass());

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

    /**
     * 关注数
     * @param fromId
     * @return
     */
    public int countByFromId(Integer fromId) {
        return friendRepository.countByFromId(fromId);
    }

    /**
     * 粉丝数
     * @param toId
     * @return
     */
    public int countByToId(Integer toId) {
        return friendRepository.countByToId(toId);
    }

    /**
     * 修改
     * @param friend
     * @return
     */
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

}

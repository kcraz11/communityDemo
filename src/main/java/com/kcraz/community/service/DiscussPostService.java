package com.kcraz.community.service;

import com.kcraz.community.dao.DiscussPostMapper;
import com.kcraz.community.dao.UserMapper;
import com.kcraz.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectPosts(userId, offset, limit);
    }
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectPostRows(userId);
    }
}

package com.kcraz.community.dao;

import com.kcraz.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //查询帖子功能，userId用于后续开发
    List<DiscussPost> selectPosts(int userId, int offset, int limit);

    //获得帖子总数; Param 用于给参数起别名；只有一个参数则必须加（存疑）
    int selectPostRows(@Param("userId") int userId);
}

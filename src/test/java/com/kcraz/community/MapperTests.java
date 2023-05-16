package com.kcraz.community;

import com.kcraz.community.dao.DiscussPostMapper;
import com.kcraz.community.dao.UserMapper;
import com.kcraz.community.entity.DiscussPost;
import com.kcraz.community.entity.User;
import com.kcraz.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserService userService;

    @Test
    public void  testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setEmail("test@sjtu.com");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testDiscussPost() {
        List<DiscussPost> list = discussPostMapper.selectPosts(0, 0, 10);
        for(DiscussPost post:list) {
            System.out.println(post);
        }
        int rows = discussPostMapper.selectPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testUserService() {
        User user = userService.findUserById(101);
        System.out.println(user);

        user = userMapper.selectById(101);
        System.out.println(user);
    }
}

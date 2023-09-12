package com.git.test;

import com.git.test.config.AnnoConfig;
import com.git.test.mapper.UserMapper;
import com.git.test.po.User;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author authorZhao
 * @since 2023-09-08
 */
public class Test1 {
    @Test
    public void test1(){
        UserMapper mapper = AnnoConfig.getSession().getMapper(UserMapper.class);
        List<User> list = mapper.list();
        System.out.println("list = " + list);
    }
}

package com.git.test.run;

import com.git.test.AnnoConfig;
import com.git.test.mapper.UserMapper;
import com.git.test.po.User;

import java.util.List;

/**
 * @author authorZhao
 * @since 2023-09-06
 */
public class TestSql {

    public static void main(String[] args) {
        UserMapper mapper = AnnoConfig.getSession().getMapper(UserMapper.class);
        List<User> list = mapper.list();
        System.out.println("list = " + list);


    }
}

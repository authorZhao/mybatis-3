package com.git.test.run;

import com.git.test.config.AnnoConfig;
import com.git.test.mapper.UserMapper;
import com.git.test.po.User;

import java.util.List;

/**
 * @author authorZhao
 * @since 2023-09-06
 */
public class TestSql {

    public static void main(String[] args) {
        //java -agentlib:native-image-agent=config-output-dir=E:\java\workspace\space3\mybatis-3\target -jar E:\java\workspace\space3\mybatis-3\target\mybatis-100-SNAPSHOT-jar-with-dependencies.jar

        UserMapper mapper = AnnoConfig.getSession().getMapper(UserMapper.class);
        List<User> list = mapper.list();
        System.out.println("list = " + list);


    }
}
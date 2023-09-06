package com.git.test.mapper;

import com.git.test.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author authorZhao
 * @since 2023-09-06
 */
public interface UserMapper {

    @Select("SELECT * FROM test_user LIMIT 50")
    @ResultType(User.class)
    List<User> list();

    User getById(@Param("id")Long id);

    boolean updateById(@Param("user")User user);

    boolean save(@Param("user")User user);
}

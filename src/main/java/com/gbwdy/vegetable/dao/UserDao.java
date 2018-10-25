package com.gbwdy.vegetable.dao;

import com.gbwdy.vegetable.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Mapper
public interface UserDao {

    @Select("select username,nickname from user where username = #{username} and password = #{password}")
    public User findUser(@Param("username") String username, @Param("password") String password);


}

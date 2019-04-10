package com.test.springbootdemo.sever.insert.dao.test;

import com.test.springbootdemo.annotations.DataBase;
import com.test.springbootdemo.sever.insert.bean.User;
import org.apache.ibatis.annotations.Insert;


public interface InsertMapper {
    @DataBase("TEST")
    @Insert("INSERT INTO `user_0` (user_id,user_name) VALUES(#{userId,jdbcType=INTEGER},#{userName,jdbcType=VARCHAR})")
    int add(User user);
}

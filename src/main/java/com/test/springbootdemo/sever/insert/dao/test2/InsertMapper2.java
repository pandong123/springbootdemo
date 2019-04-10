package com.test.springbootdemo.sever.insert.dao.test2;

import com.test.springbootdemo.annotations.DataBase;
import com.test.springbootdemo.sever.insert.bean.User;
import org.apache.ibatis.annotations.Insert;

/**
*@Author：Pandong
*@Description
*@Date:Created in 22:56 2019/4/4
*@Modified By:
*/public interface InsertMapper2 {
    @DataBase("TEST2")
    @Insert("INSERT INTO `user_0` (user_id,user_name) VALUES(#{userId,jdbcType=INTEGER},#{userName,jdbcType=VARCHAR})")
    int add(User user);
}

package com.tt.dao;

import org.apache.ibatis.annotations.Param;

import com.tt.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //校验用户名是否存在
    int checkUsername(String username);
    
    //用户名和密码查询
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
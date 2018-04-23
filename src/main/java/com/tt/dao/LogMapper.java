package com.tt.dao;

import com.tt.pojo.Log;

public interface LogMapper {
    int deleteByPrimaryKey(String id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}
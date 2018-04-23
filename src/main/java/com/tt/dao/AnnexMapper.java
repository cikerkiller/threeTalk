package com.tt.dao;

import com.tt.pojo.Annex;

public interface AnnexMapper {
    int deleteByPrimaryKey(String id);

    int insert(Annex record);

    int insertSelective(Annex record);

    Annex selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Annex record);

    int updateByPrimaryKey(Annex record);
}
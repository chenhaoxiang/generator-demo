package com.uifuture.dao;

import com.uifuture.common.BaseMapper;
import com.uifuture.entity.Book;

public interface BookMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}
package com.qf.dao;

import com.qf.bean.District;

import java.util.List;

public interface DistrictMapper {
    public List<District> findall();

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}
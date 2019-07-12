package com.qf.dao;

import com.qf.bean.AirQualityIndex;

import java.util.List;
import java.util.Map;

public interface AirQualityIndexMapper {

//    全查
    public List<AirQualityIndex> findall(Map map);

    //删除
    int deleteByPrimaryKey(Integer id);

    //添加
    int insertSelective(AirQualityIndex record);
    //主键查询
    AirQualityIndex selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKeySelective(AirQualityIndex record);


    int updateByPrimaryKey(AirQualityIndex record);

    int insert(AirQualityIndex record);
}
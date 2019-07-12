package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;

import java.util.List;
import java.util.Map;

public interface AirQualityIndexService {

    public List<District> findall();
//    全查
    public PageInfo<AirQualityIndex> findall(int disid,int index,int size);

    //删除
    int deleteByPrimaryKey(Integer id);

    //添加
    int insertSelective(AirQualityIndex record);
    //主键查询
    AirQualityIndex selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKeySelective(AirQualityIndex record);


}
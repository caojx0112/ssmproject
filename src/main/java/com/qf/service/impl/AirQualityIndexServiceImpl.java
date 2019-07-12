package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;
import com.qf.dao.AirQualityIndexMapper;
import com.qf.dao.DistrictMapper;
import com.qf.service.AirQualityIndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
@Service
public class AirQualityIndexServiceImpl implements AirQualityIndexService {
    @Resource
    private AirQualityIndexMapper airQualityIndexMapper;
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> findall() {
        return districtMapper.findall();
    }

    @Override
    public PageInfo<AirQualityIndex> findall(int disid,int index,int size) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("disid",disid);
        List<AirQualityIndex> list = airQualityIndexMapper.findall(map);
        PageInfo<AirQualityIndex> info=new PageInfo(list);
        return info;
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        return airQualityIndexMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertSelective(AirQualityIndex record) {
        return airQualityIndexMapper.insertSelective(record);
    }

    @Override
    public AirQualityIndex selectByPrimaryKey(Integer id) {
        return airQualityIndexMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(AirQualityIndex record) {
        return airQualityIndexMapper.updateByPrimaryKeySelective(record);
    }
}

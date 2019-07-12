package com.qf.bean;

import java.util.List;

public class District {
    private Integer id;

    private String name;

    private List<AirQualityIndex> airQualityIndexList;

    public List<AirQualityIndex> getAirQualityIndexList() {
        return airQualityIndexList;
    }

    public void setAirQualityIndexList(List<AirQualityIndex> airQualityIndexList) {
        this.airQualityIndexList = airQualityIndexList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
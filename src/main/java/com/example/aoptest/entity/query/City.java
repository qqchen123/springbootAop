package com.example.aoptest.entity.query;

import java.util.List;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/9/25 16:38
 */
public class City {
    private List<CityName> city;

    public List<CityName> getCity() {
        return city;
    }

    public void setCity(List<CityName> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "city=" + city +
                '}';
    }
}

class CityName {
    private List<String> cityName;

    public List<String> getCityName() {
        return cityName;
    }

    public void setCityName(List<String> cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityName{" +
                "cityName=" + cityName +
                '}';
    }
}
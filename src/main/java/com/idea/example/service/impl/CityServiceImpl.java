package com.idea.example.service.impl;

import com.idea.example.dao.CityDao;
import com.idea.example.domain.City;
import com.idea.example.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* JPA(Spring Data JPA)
* */
@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> findByCityNameLikeAndIdGreaterThan(String cityName, Long id) {
        return cityDao.findByCityNameLikeAndIdGreaterThan(cityName + "%", id);
    }

    @Override
    public List<City> findCityNameLike22(String cityName) {
        return cityDao.findCityNameLike22(cityName + "%");
    }

    @Override
    public List<City> findByCityNameLikeAndDescriptionIs(String cityName, String description) {
        return cityDao.findByCityNameLikeAndDescriptionIs(cityName + "%", description);
    }

    @Override
    public City findById22(Long id) {
        return cityDao.findById22(id);
    }

    @Override
    public int deleteIsId33(Long id) {
        return cityDao.deleteIsId33(id);
    }

    @Override
    public int deleteInIds22(String idsString) {
        String[] idsStringArray = idsString.split("\\,");
        if (idsStringArray.length == 0) {
            return 0;
        }
        List<Long> ids = Arrays.asList(idsStringArray)
                .stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return cityDao.deleteInIds22(ids);
    }

    @Override
    public int updateSetCityNameAndDescriptionInId(String cityName, String description, Long id) {
        return cityDao.updateSetCityNameAndDescriptionInId(cityName, description, id);
    }

    @Override
    public Long createCity(String cityName, String description, Long provinceId) {
        City city = new City();
        city.setCityName(cityName);
        city.setDescription(description);
        city.setProvinceId(provinceId);
        return cityDao.save(city).getId();//创建同时返回编号
    }

    @Override
    public int createCitys() {

        City city1 = new City();
        city1.setCityName("测试城市名称1");
        city1.setDescription("测试描述1");
        city1.setProvinceId(0L);

        City city2 = new City();
        city2.setCityName("测试城市名称2");
        city2.setDescription("测试描述2");
        city2.setProvinceId(0L);

        List<City> c = new ArrayList<>();
        c.add(city1);
        c.add(city2);
        return cityDao.save(c).size();//创建同时返回创建个数
    }
}

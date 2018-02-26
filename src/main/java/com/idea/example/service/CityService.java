package com.idea.example.service;

import com.idea.example.domain.City;
import java.util.List;

public interface CityService {

    List<City> findByCityNameLikeAndIdGreaterThan(String cityName, Long id);

    List<City> findCityNameLike22(String cityName);

    List<City> findByCityNameLikeAndDescriptionIs(String cityName, String description);

    City findById22(Long id);

    int deleteIsId33(Long id);

    int deleteInIds22(String idsString);

    int updateSetCityNameAndDescriptionInId(String cityName, String description, Long id);

    Long createCity(String cityName, String description, Long provinceId);

    int createCitys();
}

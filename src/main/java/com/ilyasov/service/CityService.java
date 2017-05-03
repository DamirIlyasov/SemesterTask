package com.ilyasov.service;

import com.ilyasov.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    City getCityById(Long id);
    void add (City city);
    void delete(City city);
}

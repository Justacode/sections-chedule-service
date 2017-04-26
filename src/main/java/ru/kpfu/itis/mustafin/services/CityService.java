package ru.kpfu.itis.mustafin.services;


import ru.kpfu.itis.mustafin.models.City;

import java.util.List;

public interface CityService {
    City addCity(City city);

    List<City> getAll();

    City getById(long id);

    void delete(long id);
}

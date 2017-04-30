package ru.kpfu.itis.mustafin.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.City;
import ru.kpfu.itis.mustafin.repositories.CityRepository;
import ru.kpfu.itis.mustafin.services.CityService;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository){
        this.repository = cityRepository;
    }

    public City addCity(City city) {
        return repository.save(city);
    }

    public List<City> getAll() {
        return repository.findAll();
    }

    public City getById(long id){
        return repository.findOne(id);
    }

    public City getByName(String name) {
        return repository.getByName(name);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

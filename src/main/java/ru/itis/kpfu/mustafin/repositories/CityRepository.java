package ru.itis.kpfu.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.mustafin.models.City;

public interface CityRepository extends JpaRepository<City,Long>{
}

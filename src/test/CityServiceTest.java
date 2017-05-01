import org.junit.Assert;
import org.junit.Test;

import ru.kpfu.itis.mustafin.models.City;
import ru.kpfu.itis.mustafin.repositories.CityRepository;
import ru.kpfu.itis.mustafin.services.CityService;
import ru.kpfu.itis.mustafin.services.impl.CityServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CityServiceTest {

    final CityRepository CITY_REP = mock(CityRepository.class);
    final CityService cityService = new CityServiceImpl(CITY_REP);

    @Test
    public void getByNameReturnsCorrectCity() {
        City city = new City();
        city.setName("Казань");
        when(CITY_REP.getByName("Казань")).thenReturn(city);
        City testCity = cityService.getByName("Казань");
        Assert.assertEquals(city, testCity);
    }

    @Test
    public void getAllReturnCorrectCities() {
        List<City> cities = new ArrayList<>();
        cities.add(0, new City("Москва"));
        when(CITY_REP.findAll()).thenReturn(cities);
        List<City> testCities = cityService.getAll();
        Assert.assertEquals(cities, testCities);
    }

    @Test
    public void addCityReturnsSameCity() {
        City city = new City("Йошкар-Ола");
        when(CITY_REP.save(city)).thenReturn(city);
        City testCity = cityService.addCity(city);
        Assert.assertEquals(city, testCity);
    }
}

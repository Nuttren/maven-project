package Employee;

import java.util.List;

public interface CityDAO {
    City getCityById(long id);

    void createCity(City city);

    void deleteCity(City city);

}

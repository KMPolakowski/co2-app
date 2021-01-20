package kmp.co2app.co2app.repository;

import kmp.co2app.co2app.domain.CityHall;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityHallRepository extends CrudRepository<CityHall, Long> {

    Optional<CityHall> findByCityName(String cityName);
}

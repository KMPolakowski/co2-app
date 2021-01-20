package kmp.co2app.co2app.repository;

import kmp.co2app.co2app.domain.District;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DistrictRepository extends CrudRepository<District, Long> {

    Optional<District> findByNameAndCityHallId(String name, Long CityHallId);
}

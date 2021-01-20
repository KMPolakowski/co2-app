package kmp.co2app.co2app.repository;

import kmp.co2app.co2app.domain.Measurement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {

    List<Measurement> findByCityHallCityNameAndDistrictName(String cityHallId, String districtName);
}

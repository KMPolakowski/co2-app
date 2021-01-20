package kmp.co2app.co2app.service;

import kmp.co2app.co2app.domain.CityHall;
import kmp.co2app.co2app.domain.District;
import kmp.co2app.co2app.domain.Measurement;
import kmp.co2app.co2app.model.MeasurementDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MeasurementsGetter {
    ResponseEntity<List<MeasurementDTO>> getMeasurementsFor(String cityName, String districtName);
}

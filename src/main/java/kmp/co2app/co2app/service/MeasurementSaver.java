package kmp.co2app.co2app.service;

import kmp.co2app.co2app.model.MeasurementDTO;
import org.springframework.stereotype.Service;

public interface MeasurementSaver {
    MeasurementDTO saveMeasurementForCityHallAndDistrict(MeasurementDTO measurementDTO, String cityHallName, String districtName);
}

package kmp.co2app.co2app.service;

import kmp.co2app.co2app.domain.CityHall;
import kmp.co2app.co2app.domain.Measurement;
import kmp.co2app.co2app.model.MeasurementDTO;
import kmp.co2app.co2app.model.MeasurementMapper;
import kmp.co2app.co2app.repository.MeasurementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementsGetterImpl implements MeasurementsGetter {

    private MeasurementRepository measurementRepository;
    private MeasurementMapper measurementMapper;

    public MeasurementsGetterImpl(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
    }

    @Override
    public List<MeasurementDTO> getMeasurementsFor(String cityHallName, String districtName) {
        List<MeasurementDTO> measurements = measurementRepository
                .findByCityHallCityNameAndDistrictName(cityHallName, districtName)
                .stream()
                .map(measurementMapper::measurementToMeasurementDTO)
                .collect(Collectors.toList());

        return measurements;
    }
}


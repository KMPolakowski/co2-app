package kmp.co2app.co2app.service;

import kmp.co2app.co2app.domain.CityHall;
import kmp.co2app.co2app.domain.District;
import kmp.co2app.co2app.domain.Measurement;
import kmp.co2app.co2app.model.MeasurementDTO;
import kmp.co2app.co2app.model.MeasurementMapper;
import kmp.co2app.co2app.repository.CityHallRepository;
import kmp.co2app.co2app.repository.DistrictRepository;
import kmp.co2app.co2app.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class MeasurementSaverImpl implements MeasurementSaver{

    private MeasurementRepository measurementRepository;
    private MeasurementMapper measurementMapper;
    private CityHallRepository cityHallRepository;
    private DistrictRepository districtRepository;

    public MeasurementSaverImpl(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper, CityHallRepository cityHallRepository, DistrictRepository districtRepository) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
        this.cityHallRepository = cityHallRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public MeasurementDTO saveMeasurementForCityHallAndDistrict(MeasurementDTO measurementDTO, String cityHallName, String districtName) {
        Measurement measurement = measurementMapper.measurementDTOToMeasurement(measurementDTO);

        CityHall cityHall = cityHallRepository.findByCityName(cityHallName).get();

        Optional<District> district = districtRepository.findByNameAndCityHallId(districtName, cityHall.getId());

        if(district.isEmpty())
        {
            District newDistrict = new District();
            newDistrict.setCityHall(cityHall);
            newDistrict.setName(districtName);
            newDistrict.getMeasurements().add(measurement);
            districtRepository.save(newDistrict);
            measurement.setDistrict(newDistrict);
        }
        else {
            measurement.setDistrict(district.get());
        }
        measurement.setCityHall(cityHall);

        measurement = measurementRepository.save(measurement);

        return measurementMapper.measurementToMeasurementDTO(measurement);
    }
}

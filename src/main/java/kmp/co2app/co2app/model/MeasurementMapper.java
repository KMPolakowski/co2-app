package kmp.co2app.co2app.model;

import kmp.co2app.co2app.domain.Measurement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {
    MeasurementDTO measurementToMeasurementDTO(Measurement measurement);
    Measurement measurementDTOToMeasurement(MeasurementDTO measurementDTO);
}

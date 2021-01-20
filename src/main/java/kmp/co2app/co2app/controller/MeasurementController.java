package kmp.co2app.co2app.controller;

import kmp.co2app.co2app.model.MeasurementDTO;
import kmp.co2app.co2app.service.MeasurementSaver;
import kmp.co2app.co2app.service.MeasurementsGetter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/districts/{districtName}/measurements")
public class MeasurementController {

    private MeasurementsGetter measurementsGetter;
    private MeasurementSaver measurementSaver;

    public MeasurementController(MeasurementsGetter measurementsGetter, MeasurementSaver measurementSaver) {
        this.measurementsGetter = measurementsGetter;
        this.measurementSaver = measurementSaver;
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDTO>> getMeasurements(Principal principal, @PathVariable String districtName) {
        return new ResponseEntity<List<MeasurementDTO>>(
                measurementsGetter.getMeasurementsFor(
                        principal.getName(),
                        districtName
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<MeasurementDTO> addMeasurement(
            Principal principal,
            @RequestBody MeasurementDTO measurementDTO,
            @PathVariable String districtName
    ) {
        return new ResponseEntity<MeasurementDTO>(
                measurementSaver.saveMeasurementForCityHallAndDistrict(
                        measurementDTO,
                        principal.getName(),
                        districtName
                ),
                HttpStatus.CREATED
        );
    }
}

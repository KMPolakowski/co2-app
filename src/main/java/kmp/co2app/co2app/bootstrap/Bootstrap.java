package kmp.co2app.co2app.bootstrap;

import kmp.co2app.co2app.domain.CityHall;
import kmp.co2app.co2app.domain.District;
import kmp.co2app.co2app.domain.Measurement;
import kmp.co2app.co2app.repository.CityHallRepository;
import kmp.co2app.co2app.repository.DistrictRepository;
import kmp.co2app.co2app.repository.MeasurementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Bootstrap implements CommandLineRunner {

    private CityHallRepository cityHallRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private MeasurementRepository measurementRepository;
    private DistrictRepository districtRepository;

    public Bootstrap(CityHallRepository cityHallRepository, BCryptPasswordEncoder passwordEncoder, MeasurementRepository measurementRepository, DistrictRepository districtRepository) {
        this.cityHallRepository = cityHallRepository;
        this.passwordEncoder = passwordEncoder;
        this.measurementRepository = measurementRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        CityHall vienna = new CityHall();
        vienna.setCityName("vienna");
        vienna.setToken(passwordEncoder.encode("schnitzel"));

        District first = new District();
        first.setName("innenstadt");
        first.setCityHall(vienna);

        District waehring = new District();
        waehring.setName("waehring");
        waehring.setCityHall(vienna);


        District doebling = new District();
        waehring.setName("doebling");
        doebling.setCityHall(vienna);

        vienna.getDistricts().add(first);
        vienna.getDistricts().add(waehring);
        vienna.getDistricts().add(doebling);


        CityHall barcelona = new CityHall();
        barcelona.setCityName("barcelona");
        barcelona.setToken(passwordEncoder.encode("burito"));

        District gracia = new District();
        gracia.setName("graica");

        District eixample = new District();
        gracia.setName("eixample");

        barcelona.getDistricts().add(gracia);
        barcelona.getDistricts().add(eixample);



        CityHall munich = new CityHall();
        munich.setCityName("munich");
        munich.setToken(passwordEncoder.encode("frankfurter"));

        District maxvorstadt = new District();
        maxvorstadt.setName("maxvorstadt");

        munich.getDistricts().add(maxvorstadt);


        Measurement measurement = new Measurement();
        measurement.setValue(123.123);
        measurement.setCityHall(vienna);
        measurement.setDistrict(first);

        cityHallRepository.save(vienna);
        cityHallRepository.save(munich);
        cityHallRepository.save(barcelona);

        measurementRepository.save(measurement);
    }
}

package kmp.co2app.co2app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CityHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cityName;
    private String token;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_hall_id")
    private Set<District> districts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_hall_id")
    private Set<Measurement> measurements = new HashSet<>();

    public CityHall(Long id, String cityName, String token, Set<District> districts, Set<Measurement> measurements) {
        this.id = id;
        this.cityName = cityName;
        this.token = token;
        this.districts = districts;
        this.measurements = measurements;
    }

    public Set<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Set<Measurement> measurements) {
        this.measurements = measurements;
    }

    public CityHall() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }
}

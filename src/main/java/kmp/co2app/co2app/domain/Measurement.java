package kmp.co2app.co2app.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp createdAt;

    private Double value;

    @ManyToOne
    private District district;

    @ManyToOne
    private CityHall cityHall;

    public Measurement(Long id, Timestamp createdAt, Double value, District district, CityHall cityHall) {
        this.id = id;
        this.createdAt = createdAt;
        this.value = value;
        this.district = district;
        this.cityHall = cityHall;
    }

    public CityHall getCityHall() {
        return cityHall;
    }

    public void setCityHall(CityHall cityHall) {
        this.cityHall = cityHall;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Measurement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}

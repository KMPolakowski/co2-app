package kmp.co2app.co2app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private CityHall cityHall;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private Set<Measurement> measurements = new HashSet<>();

    public District() {
    }

    public District(Long id, String name, CityHall cityHall, Set<Measurement> measurements) {
        this.id = id;
        this.name = name;
        this.cityHall = cityHall;
        this.measurements = measurements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityHall getCityHall() {
        return cityHall;
    }

    public void setCityHall(CityHall cityHall) {
        this.cityHall = cityHall;
    }

    public Set<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Set<Measurement> measurements) {
        this.measurements = measurements;
    }


}

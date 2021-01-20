package kmp.co2app.co2app.model;

import java.sql.Time;
import java.sql.Timestamp;

public class MeasurementDTO {
    private Double value;
    private Timestamp createdAt;

    public MeasurementDTO(Double value, Timestamp createdAt) {
        this.value = value;
        this.createdAt = createdAt;
    }

    public MeasurementDTO() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

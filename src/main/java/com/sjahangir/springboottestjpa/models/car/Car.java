package com.sjahangir.springboottestjpa.models.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Make of car must be given.")
    private String make;

    @NotBlank(message = "Model of car must be given.")
    private String model;

    public Car() {
    }

    public Car(final int id, final String make, final String model) {
        this.id = id;
        this.make = make;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(final String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

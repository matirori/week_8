package com.rohraff.week8.repository;

import javax.persistence.*;

@Entity
@Table(name = "weathers")
public class BasicWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature;
    @Column(name = "feels_temperature")
    private double feelsTemperature;
    @Column(name = "wind_speed")
    private double windSpeed;
    private double pressure;

    public BasicWeather(double temperature, double feelsTemperature, double windSpeed, double pressure) {
        this.temperature = temperature;
        this.feelsTemperature = feelsTemperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    public BasicWeather() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsTemperature() {
        return feelsTemperature;
    }

    public void setFeelsTemperature(double feelsTemperature) {
        this.feelsTemperature = feelsTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String description) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "BasicWeather{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", feelsTemperature=" + feelsTemperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                '}';
    }
}

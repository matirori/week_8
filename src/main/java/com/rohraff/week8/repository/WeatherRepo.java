package com.rohraff.week8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<BasicWeather, Long> {
}

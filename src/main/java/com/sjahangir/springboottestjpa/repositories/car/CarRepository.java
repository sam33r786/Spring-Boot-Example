package com.sjahangir.springboottestjpa.repositories.car;

import com.sjahangir.springboottestjpa.models.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}

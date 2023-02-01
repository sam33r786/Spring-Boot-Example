package com.sjahangir.springboottestjpa.services.car;

import com.sjahangir.springboottestjpa.models.car.Car;
import com.sjahangir.springboottestjpa.repositories.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(final int id) {
        return carRepository.findById(id).orElseThrow(() -> {
            String message = String.format("Car not found for ID: %d", id);
            throw new CarNotFoundException(message);
        });
    }

    public void deleteCar(final int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow(() -> {
            String message = String.format("Car not found for ID: %d", id);
            throw new CarNotFoundException(message);
        });
        carRepository.delete(carToDelete);
    }

    public Car addCar(final Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(final int id, final Car updatedCar) {
        var car = carRepository.findById(id).orElseThrow(() -> {
            String message = String.format("Car not found for ID: %d", id);
            throw new CarNotFoundException(message);
        });

        car.setMake(updatedCar.getMake());
        car.setModel(updatedCar.getModel());

        return carRepository.save(car);
    }
}

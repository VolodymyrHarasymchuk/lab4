package lab4.repository;

import lab4.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TakenRepository {
    private final CarRepository carRepository;
    private final List<Car> takenCars = new ArrayList<>();

    @Autowired
    public TakenRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getTakenCars() {
        return new ArrayList<>(takenCars);
    }

    public boolean takeCarForDrive(int id) {
        List<Car> carList = carRepository.getAllCars();
        for (Car car : carList) {
            if(car.getId() == id) {
                takenCars.add(car);
                carList.remove(car);
                return true;
            }
        }
        return false;
    }

    public boolean returnCar(int id) {
        List<Car> carList = carRepository.getAllCars();
        for (Car car : takenCars) {
            if(car.getId() == id) {
                carList.add(car);
                takenCars.remove(car);
                return true;
            }
        }
        return false;
    }
}

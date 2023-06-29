package lab4.service;

import lab4.model.Car;
import lab4.repository.TakenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenService {
    private final TakenRepository takenRepository;

    @Autowired
    public TakenService(TakenRepository takenRepository) {
        this.takenRepository = takenRepository;
    }

    public List<Car> getTakenCars() {
        return takenRepository.getTakenCars();
    }

    public boolean takeCarForDrive(int id) {
        return takenRepository.takeCarForDrive(id);
    }

    public boolean returnCar(int id) {
        return takenRepository.returnCar(id);
    }
}

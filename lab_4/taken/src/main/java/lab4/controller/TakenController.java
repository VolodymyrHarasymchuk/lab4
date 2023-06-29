package lab4.controller;

import lab4.model.Car;
import lab4.service.TakenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class TakenController {
    @Autowired
    private TakenService takenService;

    @GetMapping("/taken")
    public List<Car> getTakenCars() {
        return takenService.getTakenCars();
    }

    @PutMapping("/take")
    public void takeCarForDrive(@RequestParam int id) throws Exception {
        if (!takenService.takeCarForDrive(id)) {
            throw new Exception();
        }
    }

    @PutMapping("/return")
    public void returnCar(@RequestParam int id) throws Exception {
        if (!takenService.returnCar(id)) {
            throw new Exception();
        }
    }
}

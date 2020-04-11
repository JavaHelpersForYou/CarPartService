package com.example.demo.controller;

import com.example.demo.dto.car.CarDTO;
import com.example.demo.service.car.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public Page<CarDTO> findAllCars(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 15) Pageable page) {
        return carService.findAllCars(page);
    }

    @GetMapping("/{id}")
    public CarDTO findById(@PathVariable long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarDTO createCar(CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable long id, CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }
}

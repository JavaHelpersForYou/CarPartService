package com.example.demo.controller;

import com.example.demo.dto.car.CarDTO;
import com.example.demo.service.car.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CarDTO> findAllCars(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 15) Pageable page) {
        return carService.findAllCars(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO findById(@PathVariable long id) {
        return carService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CarDTO updateCar(@PathVariable long id, @RequestBody CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }
}

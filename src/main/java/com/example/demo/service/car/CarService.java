package com.example.demo.service.car;

import com.example.demo.dto.car.CarDTO;
import com.example.demo.dto.car.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private CarMapper carMapper;

    public CarDTO findById(Long id) throws Exception {
        return carRepository
                .findById(id)
                .map(carMapper::carToCarDto)
                .orElseThrow(Exception::new);
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car car = Car.builder()
                .name(carDTO.getName())
                .model(carDTO.getModel())
                .mark(carDTO.getMark())
                .age(carDTO.getAge())
                .price(carDTO.getPrice())
                .countryOfManufacture(carDTO.getCountryOfManufacture())
                .detailsList(carDTO.getDetailsList())
                .build();

        Car saveCar = carRepository.saveAndFlush(car);
        return carMapper.carToCarDto(saveCar);
    }

    public void deleteCar(Long id) throws Exception {
        Car car = carRepository.findById(id)
                .orElseThrow(Exception::new);
        carRepository.delete(car);
    }
}

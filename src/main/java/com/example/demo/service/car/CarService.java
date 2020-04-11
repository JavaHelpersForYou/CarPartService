package com.example.demo.service.car;

import com.example.demo.dto.car.CarDTO;
import com.example.demo.dto.car.CarMapper;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarDTO findById(Long id) {
        return carRepository
                .findById(id)
                .map(carMapper::carToCarDto)
                .orElseThrow(ResourceNotFoundException::new);
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

    public void deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        carRepository.delete(car);
    }

    public Page<CarDTO> findAllCars(Pageable pageable) {
        return carMapper.carToCarDTOs(carRepository.findAll(pageable));
    }

    public CarDTO updateCar(long id, CarDTO carDTO) {
        Car carUpdateById = carRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        Car actualCar = carMapper.carDtoToCar(carDTO);

        carUpdateById.setName(actualCar.getName());
        carUpdateById.setModel(actualCar.getModel());
        carUpdateById.setMark(actualCar.getMark());
        carUpdateById.setAge(actualCar.getAge());
        carUpdateById.setPrice(actualCar.getPrice());
        carUpdateById.setCountryOfManufacture(actualCar.getCountryOfManufacture());
        carUpdateById.setDetailsList(actualCar.getDetailsList());

        return carMapper.carToCarDto(carRepository.save(carUpdateById));
    }
}

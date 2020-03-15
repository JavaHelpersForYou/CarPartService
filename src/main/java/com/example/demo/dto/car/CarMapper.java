package com.example.demo.dto.car;

import com.example.demo.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CarMapper {
    default CarDTO carToCarDto(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .name(car.getName())
                .model(car.getModel())
                .mark(car.getMark())
                .age(car.getAge())
                .price(car.getPrice())
                .countryOfManufacture(car.getCountryOfManufacture())
                .detailsList(car.getDetailsList())
                .build();
    }

    default Car carDtoToCar(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .name(carDTO.getName())
                .model(carDTO.getModel())
                .mark(carDTO.getMark())
                .age(carDTO.getAge())
                .price(carDTO.getPrice())
                .countryOfManufacture(carDTO.getCountryOfManufacture())
                .detailsList(carDTO.getDetailsList())
                .build();
    }

    default Page<CarDTO> carToCarDTOs(Page<Car> cars) {
        return cars.map(this::carToCarDto);
    }
}

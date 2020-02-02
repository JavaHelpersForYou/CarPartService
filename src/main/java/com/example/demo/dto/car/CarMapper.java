package com.example.demo.dto.car;

import com.example.demo.model.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface CarMapper {
    CarDTO carToCarDto(Car car);

    Car carDtoToCar(CarDTO carDTO);
}

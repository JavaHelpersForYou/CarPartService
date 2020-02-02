package com.example.demo.dto.car;

import com.example.demo.model.PartDetails;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String name;
    private String model;
    private String mark;
    private Integer age;
    private String price;
    private String countryOfManufacture;
    private List<PartDetails> detailsList;
}

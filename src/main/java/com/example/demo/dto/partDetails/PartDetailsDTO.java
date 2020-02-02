package com.example.demo.dto.partDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PartDetailsDTO {
    private Long id;
    private String name;
    private String model;
    private String mark;
    private Integer age;
    private String price;
    private String countryOfManufacture;
    private Integer amount;
}

package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "part_details")
public class PartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String model;

    @NonNull
    private String mark;

    @NonNull
    private Integer age;

    @NonNull
    private String price;

    @NonNull
    private String countryOfManufacture;

    @NonNull
    private Integer amount;
}

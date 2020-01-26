package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "car")
public class Car {

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

    @ManyToMany
    @JoinTable(
            name = "car_part_details",
            joinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "part_details_id", referencedColumnName = "id")}
    )
    private List<PartDetails> detailsList = new ArrayList<>();
}

package com.example.demo.dto.partDetails;

import com.example.demo.model.PartDetails;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PartDetailsMapper {
    public PartDetailsDTO partDetailsToPartDetailsDto(PartDetails partDetails) {
        return PartDetailsDTO.builder()
                .id(partDetails.getId())
                .name(partDetails.getName())
                .model(partDetails.getModel())
                .mark(partDetails.getMark())
                .age(partDetails.getAge())
                .price(partDetails.getPrice())
                .countryOfManufacture(partDetails.getCountryOfManufacture())
                .amount(partDetails.getAmount())
                .build();
    }

    public PartDetails partDetailsDtoToPartDetails(PartDetailsDTO partDetailsDTO) {
        return PartDetails.builder()
                .id(partDetailsDTO.getId())
                .name(partDetailsDTO.getName())
                .model(partDetailsDTO.getModel())
                .mark(partDetailsDTO.getMark())
                .age(partDetailsDTO.getAge())
                .price(partDetailsDTO.getPrice())
                .countryOfManufacture(partDetailsDTO.getCountryOfManufacture())
                .amount(partDetailsDTO.getAmount())
                .build();
    }

    public Page<PartDetailsDTO> partDetailsToPartDetailsDTOs(Page<PartDetails> partDetails) {
        return partDetails.map(this::partDetailsToPartDetailsDto);
    }
}

package com.example.demo.dto.partDetails;

import com.example.demo.model.PartDetails;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface PartDetailsMapper {
    PartDetailsDTO partDetailsToPartDetailsDto(PartDetails partDetails);

    PartDetails partDetailsDtoToPartDetails(PartDetailsDTO partDetailsDTO);
}

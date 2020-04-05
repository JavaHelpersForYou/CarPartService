package com.example.demo.service.partDetails;

import com.example.demo.dto.partDetails.PartDetailsDTO;
import com.example.demo.dto.partDetails.PartDetailsMapper;
import com.example.demo.model.PartDetails;
import com.example.demo.repository.PartDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PartDetailsService {

    private PartDetailsRepository partDetailsRepository;
    private PartDetailsMapper partDetailsMapper;

    public PartDetailsDTO findById(Long id) throws Exception {
        return partDetailsRepository
                .findById(id)
                .map(partDetailsMapper::partDetailsToPartDetailsDto)
                .orElseThrow(Exception::new);
    }

    public PartDetailsDTO createPartDetails(PartDetailsDTO partDetailsDTO) {
        PartDetails partDetails = PartDetails.builder()
                .name(partDetailsDTO.getName())
                .model(partDetailsDTO.getModel())
                .mark(partDetailsDTO.getMark())
                .age(partDetailsDTO.getAge())
                .price(partDetailsDTO.getPrice())
                .countryOfManufacture(partDetailsDTO.getCountryOfManufacture())
                .amount(partDetailsDTO.getAmount())
                .build();

        return partDetailsMapper.partDetailsToPartDetailsDto(partDetailsRepository.saveAndFlush(partDetails));
    }

    public void deletePartDetails(Long id) throws Exception {
        partDetailsRepository.delete(
                partDetailsRepository
                        .findById(id)
                        .orElseThrow(Exception::new)
        );
    }

    public Page<PartDetailsDTO> findAllPartDetails(Pageable pageable) {
        return partDetailsMapper.partDetailsToPartDetailsDTOs(partDetailsRepository.findAll(pageable));
    }
}

package com.example.demo.service.partDetails;

import com.example.demo.dto.partDetails.PartDetailsDTO;
import com.example.demo.dto.partDetails.PartDetailsMapper;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PartDetails;
import com.example.demo.repository.PartDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartDetailsService {

    private final PartDetailsRepository partDetailsRepository;
    private final PartDetailsMapper partDetailsMapper;

    public PartDetailsDTO findById(Long id) {
        return partDetailsRepository
                .findById(id)
                .map(partDetailsMapper::partDetailsToPartDetailsDto)
                .orElseThrow(ResourceNotFoundException::new);
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

    public void deletePartDetails(Long id) {
        partDetailsRepository.delete(
                partDetailsRepository
                        .findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    public Page<PartDetailsDTO> findAllPartDetails(Pageable pageable) {
        return partDetailsMapper.partDetailsToPartDetailsDTOs(partDetailsRepository.findAll(pageable));
    }

    public PartDetailsDTO updatePartDetails(long id, PartDetailsDTO partDetailsDTO) {
        PartDetails partDetailsUpdateById = partDetailsRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        PartDetails actualPartDetails = partDetailsMapper.partDetailsDtoToPartDetails(partDetailsDTO);

        partDetailsUpdateById.setName(actualPartDetails.getName());
        partDetailsUpdateById.setMark(actualPartDetails.getMark());
        partDetailsUpdateById.setMark(actualPartDetails.getMark());
        partDetailsUpdateById.setAge(actualPartDetails.getAge());
        partDetailsUpdateById.setPrice(actualPartDetails.getPrice());
        partDetailsUpdateById.setCountryOfManufacture(actualPartDetails.getCountryOfManufacture());
        partDetailsUpdateById.setAge(actualPartDetails.getAge());

        return partDetailsMapper.partDetailsToPartDetailsDto(partDetailsRepository.saveAndFlush(partDetailsUpdateById));
    }
}

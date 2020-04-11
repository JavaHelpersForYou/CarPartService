package com.example.demo.controller;


import com.example.demo.dto.partDetails.PartDetailsDTO;
import com.example.demo.service.partDetails.PartDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/part_details")
@AllArgsConstructor
public class PartDetailsController {

    private final PartDetailsService partDetailsService;

    @GetMapping
    public Page<PartDetailsDTO> findAllPartDetails(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable page) {
        return partDetailsService.findAllPartDetails(page);
    }

    @GetMapping("/{id}")
    public PartDetailsDTO findById(@PathVariable long id) {
        return partDetailsService.findById(id);
    }

    @PostMapping
    public PartDetailsDTO createPartDetails(PartDetailsDTO carDTO) {
        return partDetailsService.createPartDetails(carDTO);
    }

    @PutMapping("/{id}")
    public PartDetailsDTO updatePartDetails(@PathVariable long id, PartDetailsDTO partDetailsDTO) {
        return partDetailsService.updatePartDetails(id, partDetailsDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePartDetails(@PathVariable long id) {
        partDetailsService.deletePartDetails(id);
    }
}

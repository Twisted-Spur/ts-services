package com.twistedspur.service;

import com.twistedspur.dto.CategoryDto;
import com.twistedspur.dto.PrintPlacementDto;
import com.twistedspur.entity.Category;
import com.twistedspur.entity.Print;
import com.twistedspur.entity.PrintPlacement;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.CategoryMapper;
import com.twistedspur.mapper.PrintPlacementMapper;
import com.twistedspur.repository.CategoriesRepository;
import com.twistedspur.repository.PrintPlacementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PrintPlacementsService {
    @Autowired
    PrintPlacementsRepository printPlacementsRepository;

    @Autowired
    PrintPlacementMapper printPlacementMapper;

    public PrintPlacementDto createPrintPlacement(PrintPlacementDto printPlacementDto) {
        PrintPlacement printPlacement = printPlacementMapper.toEntity(printPlacementDto);
        printPlacementsRepository.save(printPlacement);
        return printPlacementMapper.toDto(printPlacement);
    }

    public List<PrintPlacementDto> getAllPrintPlacements() {
        return printPlacementMapper.toDto(printPlacementsRepository.findAll());
    }

    public PrintPlacementDto updatePrintPlacement(@PathVariable Integer id, @RequestBody String updatedPrintPlacementName) {
        Optional<PrintPlacement> optPrintPlacement = printPlacementsRepository.findById(id);

        if (optPrintPlacement.isEmpty()) {
            throw new NotFoundException("Print placement with id " + id + " not found");
        }

        PrintPlacement printPlacement = optPrintPlacement.get();
        printPlacement.setPlacement(updatedPrintPlacementName);
        printPlacementsRepository.save(printPlacement);
        return printPlacementMapper.toDto(printPlacement);
    }

    public void deletePrintPlacement(@PathVariable Integer id) {
        printPlacementsRepository.deleteById(id);
    }
}

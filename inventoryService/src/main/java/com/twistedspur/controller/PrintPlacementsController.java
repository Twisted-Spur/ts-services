package com.twistedspur.controller;

import com.twistedspur.dto.PrintPlacementDto;
import com.twistedspur.service.PrintPlacementsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/printPlacements")
@Tag(name = "Print Placements Management", description = "Operations to perform print placements management")
public class PrintPlacementsController {

        @Autowired
        PrintPlacementsService printPlacementsService;

        // Create a new print placement
        @PostMapping
        public PrintPlacementDto createPrintPlacement(@RequestBody PrintPlacementDto printPlacementDto) {
            return printPlacementsService.createPrintPlacement(printPlacementDto);
        }

        // Get all print placements
        @GetMapping
        public List<PrintPlacementDto> getAllPrintPlacements() {
            return printPlacementsService.getAllPrintPlacements();
        }

        // Update a print placement
        @PutMapping("/{id}")
        public PrintPlacementDto updatePrintPlacement(@PathVariable Integer id, @RequestBody String updatedPrintPlacementName) {
            return printPlacementsService.updatePrintPlacement(id, updatedPrintPlacementName);
        }

        // Delete a print placement
        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Integer id) {
                printPlacementsService.deletePrintPlacement(id);
        }
}

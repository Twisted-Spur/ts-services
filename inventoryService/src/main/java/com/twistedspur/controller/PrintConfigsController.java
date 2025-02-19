package com.twistedspur.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/printConfigurations")
@Tag(name = "Print Configuration Management", description = "Operations to perform print configuration management")
public class PrintConfigsController {
        // TODO - move code to order service

//        @Autowired
//        PrintConfigsService printConfigsService;
//
//        // Create new print configurations, instead of one, with the expectation that often more than one print config
//        // will need to be created by the customer for the cart item
//        @PostMapping
//        public List<PrintConfigurationDto> createPrintConfigurations(@RequestBody List<PrintConfigurationDto> printConfigurationDtos) {
//            return printConfigsService.createPrintPlacement(printConfigurationDtos);
//        }
//
//        // Get all print configurations tied to a cart item
//        @GetMapping{"/{cart_item_id"}
//        public List<PrintConfigurationDto> getAllPrintConfigurationsByOrderItem() {
//            return printConfigsService.getAllPrintPlacements();
//        }
//
//        // Update a print configuration
//        @PutMapping("/{id}")
//        public PrintPlacementDto updatePrintPlacement(@PathVariable Integer id, @RequestBody String updatedPrintPlacementName) {
//            return printConfigsService.updatePrintPlacement(id, updatedPrintPlacementName);
//        }
//
//        // Delete a print configuration
//        @DeleteMapping("/{id}")
//        public void deleteUser(@PathVariable Integer id) {
//                printConfigsService.deletePrintPlacement(id);
//        }
}

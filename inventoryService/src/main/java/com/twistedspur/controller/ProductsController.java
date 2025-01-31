package com.twistedspur.controller;

import com.twistedspur.dto.PrintDto;
import com.twistedspur.service.PrintsService;
import com.twistedspur.service.ProductsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products Management", description = "Operations to perform products management")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    // Create a new product entry
//    @PostMapping(consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
//    public PrintDto createPrint(
//            @RequestPart("printDto") PrintDto printDto,
//            @RequestPart("file") MultipartFile multipartFile) {
//        return printsService.createPrint(multipartFile, printDto);
//    }
//
//    // Get all Prints
//    // TODO - a similar endpoint should have filterable criteria for paging through prints
//    @GetMapping
//    public List<PrintDto> getAllUsers() {
//        return printsService.getAllPrints();
//    }
//
//    // Get a single print by its id
//    @GetMapping("/{id}")
//    public PrintDto getCategoryById(@PathVariable Integer id) {
//        return printsService.getPrintById(id);
//    }
//
//    // Update a print
//    @PutMapping(consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
//    public PrintDto updatePrint(
//            @RequestPart("printDto") PrintDto printDto,
//            @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
//        return printsService.updatePrint(printDto, multipartFile);
//    }
//
//    // Delete a print
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        printsService.deletePrint(id);
//    }
}

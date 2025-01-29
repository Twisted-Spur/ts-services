package com.twistedspur.controller;

import com.twistedspur.dto.PrintDto;
import com.twistedspur.service.PrintsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/prints")
@Tag(name = "Prints Management", description = "Operations to perform print management")
public class PrintsController {

    @Autowired
    PrintsService printsService;

    // Create a new print entry
    @PostMapping(consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public PrintDto createPrint(
            @RequestPart("printDto") PrintDto printDto,
            @RequestPart("file") MultipartFile multipartFile) {
        return printsService.createPrint(multipartFile, printDto);
    }

//    // Get all Prints
//    // TODO - a similar endpoint should have filterable criteria for paging through prints
//    @GetMapping
//    public List<CategoryDto> getAllUsers() {
//        return categoriesService.getAllCategories();
//    }
//
//    // Get a single print by its id
//    @GetMapping("/{id}")
//    public CategoryDto getCategoryById(@PathVariable Integer id) {
//        return categoriesService.getCategoryById(id);
//    }
//
//    // Update a print
//    @PutMapping("/{id}")
//    public CategoryDto updateCategory(@PathVariable Integer id, @RequestBody String updatedCategoryName) {
//        return categoriesService.updateCategory(id, updatedCategoryName);
//    }
//
//    // Delete a print
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        categoriesService.deleteCategory(id);
//    }
}

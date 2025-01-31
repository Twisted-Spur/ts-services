package com.twistedspur.service;

import com.twistedspur.mapper.ProductMapper;
import com.twistedspur.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductMapper productMapper;


}

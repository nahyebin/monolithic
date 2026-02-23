package com.example.monolithic.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monolithic.product.dao.ProductRepository;
import com.example.monolithic.user.dao.UserRepository;
import com.example.monolithic.user.domain.dto.ProductRequestDTO;
import com.example.monolithic.user.domain.dto.ProductResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductResponseDTO productCreate(ProductRequestDTO request) {
        System.out.println(">>>> product service productCreate");

        
        return null;
    }
    
}

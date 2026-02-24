package com.example.monolithic.product.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monolithic.product.dao.ProductRepository;
import com.example.monolithic.product.domain.dto.ProductRequestDTO;
import com.example.monolithic.product.domain.dto.ProductResponseDTO;
import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.dao.UserRepository;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // 보안적으로 안정
    public ProductResponseDTO productCreate(ProductRequestDTO request) {
        System.out.println(">>>> product service productCreate");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(">>>> auth getName : "+auth.getName()); // user정보확인
        UserEntity user = userRepository.findById(auth.getName())
                                .orElseThrow(() -> 
                                    new RuntimeException("User Not Found!!")) ;
        
        // context정보로 로그인 사용자 확인                            
        ProductEntity product = request.toEntity(user);
        return ProductResponseDTO.fromEntity(productRepository.save(product)); 
    }
    
}

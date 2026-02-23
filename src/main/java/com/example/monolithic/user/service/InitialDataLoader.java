package com.example.monolithic.user.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.monolithic.user.dao.UserRepository;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

//객체 생성
@Component
//의존성 주입
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder;

    // 데이터 초기화 작업
    @Override
    public void run(String... args) throws Exception{
        System.out.println(">>>> InitialDataLoader run called....");
        if(userRepository.findById("admin@naver.com").isPresent()) {
            return;
        }

        UserEntity user = UserEntity.builder()
            .email("admin@naver.com")
            .name("admin")
            //.password("123456789")
            .password(passwordEncoder.encode("123456789")) //해싱처리해달라
            .role("ADMIN")
            .build();

        userRepository.save(user);
    }
    
}

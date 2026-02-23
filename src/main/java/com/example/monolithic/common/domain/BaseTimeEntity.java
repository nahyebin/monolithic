package com.example.monolithic.common.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseTimeEntity { //생성, 업데이트, 삭제 시점 관리
    
    @CreationTimestamp
    private LocalDateTime createAt;
    @CreationTimestamp
    private LocalDateTime updateAt;
    @CreationTimestamp
    private LocalDateTime deleteAt;
    
}

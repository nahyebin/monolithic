package com.example.monolithic.user.domain.entity;

import java.util.ArrayList;

import javax.management.relation.Role;

import com.example.monolithic.common.domain.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name="MONOLITHIC_USER_TBL")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity{

    @Id
    private String email;

    @Column(unique = true, nullable = false, length = 200)
    private String password;

    private String name;

    // @Enumerated(EnumType.STRING)
    // @Builder.Default
    // private Role role = Role.USER;

    private String role ;

    
}

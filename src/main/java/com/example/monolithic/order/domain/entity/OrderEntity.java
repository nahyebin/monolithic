package com.example.monolithic.order.domain.entity;

import com.example.monolithic.common.domain.BaseTimeEntity;
import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.domain.entity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MONOLITHIC_ORDER_TBL")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseTimeEntity{ //주문관리-사용자, 제품 정보=> 어떤 사용자가 어떤 제품 구매했는지 -> 주문 아이디 생성
    // 주문 번호 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //사용자 주문시
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private ProductEntity product;

    //수량관리 - 주문된 수량 관리
    private Integer qty;

    // 주문 상태 관리 - 기본값 ORDERED로 설정
    // @Builder 사용하면 기본값 무시할 수 있어서 @Builder.Default 설정
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.ORDERED;
    
}

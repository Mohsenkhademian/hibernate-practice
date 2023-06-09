package com.example.entity;

import com.example.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "productEntity")
@Table(name = "product_tbl")
public class Product extends BaseEntity {

    @Column(name = "name", columnDefinition = "NVARCHAR2(50)")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

package com.example.entity;

import com.example.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "categoryEntity")
@Table(name = "category_tbl")
public class Category extends BaseEntity {

    @Column(name = "name", columnDefinition = "NVARCHAR2(30)")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}

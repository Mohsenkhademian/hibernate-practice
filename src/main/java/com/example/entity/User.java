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

@Entity(name = "userEntity")
@Table(name = "user_tbl")
public class User extends BaseEntity {

    @Column(name = "user_name", columnDefinition = "NVARCHAR2(20)")
    private String userName;

    @Column(name = "password", columnDefinition = "NVARCHAR2(12)")
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public void setActive(boolean isActive) {
    }

    public void setDeleted(boolean isDeleted) {
    }
}

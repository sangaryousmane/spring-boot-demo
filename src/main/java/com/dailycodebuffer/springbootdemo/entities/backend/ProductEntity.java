package com.dailycodebuffer.springbootdemo.entities.backend;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ProductEntity")
@Getter @Setter @Builder @AllArgsConstructor
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Integer unitInStock;
    private Integer unitOnOrder;
    private String unitPrice;

    public ProductEntity() {

    }
}

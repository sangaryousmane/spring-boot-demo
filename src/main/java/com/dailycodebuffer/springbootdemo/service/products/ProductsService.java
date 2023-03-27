package com.dailycodebuffer.springbootdemo.service.products;

import com.dailycodebuffer.springbootdemo.models.Product;

import java.util.List;

public interface ProductsService {

    Product saveProducts(Product product);

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    Product updateProduct(Integer id, Product product);

    boolean deleteProduct(Integer Id);
}

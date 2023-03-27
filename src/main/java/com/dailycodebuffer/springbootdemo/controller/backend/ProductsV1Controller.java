package com.dailycodebuffer.springbootdemo.controller.backend;


import com.dailycodebuffer.springbootdemo.models.Product;
import com.dailycodebuffer.springbootdemo.service.products.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/v1/products")
public class ProductsV1Controller {


    @Qualifier(value = "productServiceImpl")
    private final ProductServiceImpl productServiceImpl;

    public ProductsV1Controller(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    // Get All Products
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }

    // Save Products
    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productServiceImpl.saveProducts(product);
    }

    // Get Product by Id
    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable Integer Id){
        return productServiceImpl.getProductById(Id);
    }

    // Delete Product By id
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Integer Id) {
        boolean isDeleted = false;
        isDeleted = productServiceImpl.deleteProduct(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);
        return ResponseEntity.ok(response);
    }

    // Update Product
    @PutMapping("/update/{Id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable Integer Id) {
        Product updateProduct = productServiceImpl.updateProduct(Id, product);
        return ResponseEntity.ok(updateProduct);
    }

}

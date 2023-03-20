package com.dailycodebuffer.springbootdemo.service.products;

import com.dailycodebuffer.springbootdemo.entities.backend.ProductEntity;
import com.dailycodebuffer.springbootdemo.models.Product;
import com.dailycodebuffer.springbootdemo.repository.backend.ProductEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductsService {


    private final ProductEntityRepository entityRepository;

    public ProductServiceImpl(ProductEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Product saveProducts(Product product) {
        ProductEntity productEntity=new ProductEntity();
        product.setUnitPrice("$"+product.getUnitPrice());
        BeanUtils.copyProperties(product, productEntity);
        entityRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = entityRepository.findAll();

        return productEntities.stream()
                .map(products ->{
                    Product product=new Product();
                    BeanUtils.copyProperties(productEntities, product);
                    return product;
                }).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Integer id) {
        ProductEntity productId = entityRepository.findById(id).get();
        Product product=new Product();
        BeanUtils.copyProperties(productId, product);
        return product;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        ProductEntity productEntity=new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        entityRepository.save(productEntity);
        return product;
    }

    @Override
    public boolean deleteProduct(Integer Id) {
        ProductEntity productEntityById = entityRepository.findById(Id).get();
        entityRepository.delete(productEntityById);
        return true;
    }
}

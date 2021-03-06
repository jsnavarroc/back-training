package co.jsnvarroc.orders.product.services;

import co.jsnvarroc.orders.product.domain.*;
import co.jsnvarroc.orders.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServies {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServies(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductOperation insertProduct(ProductOperationRequest productOperationRequest){
        Product product = productRepository.insertOne(productOperationRequest);
        return ProductOperationSuccess.of(product);
    }

    public ProductOperation findById(ProductId productId){
        return  productRepository.findById(productId);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public ProductOperation updateOne(ProductId productId, ProductOperationRequest productOperationRequest){
        return productRepository.updateOne(productId,productOperationRequest);
    }
    public ProductOperation deleteOne(ProductId productId){
        return productRepository.deleteOne(productId);
    }

}

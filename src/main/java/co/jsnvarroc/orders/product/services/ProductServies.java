package co.jsnvarroc.orders.product.services;

import co.jsnvarroc.orders.product.domain.*;
import co.jsnvarroc.orders.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

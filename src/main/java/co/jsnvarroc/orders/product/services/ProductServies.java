package co.jsnvarroc.orders.product.services;

import co.jsnvarroc.orders.product.domain.Product;
import co.jsnvarroc.orders.product.domain.ProductId;
import co.jsnvarroc.orders.product.domain.ProductOperationRequest;
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

    public Product insertProduct(ProductOperationRequest productOperationRequest){
        Product product = productRepository.insertOne(productOperationRequest);
        return product;
    }
}

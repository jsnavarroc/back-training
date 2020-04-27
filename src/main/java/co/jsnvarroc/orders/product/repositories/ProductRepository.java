package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.product.domain.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {
    Product insertOne(ProductOperationRequest productOperationRequest);
    Optional<Product> findById(ProductId productId);
    Optional<Product> findAll();
    Optional<Product> updateOne(ProductId productId, ProductOperationRequest productOperationRequest);
    Optional<ProductOperationRequest> deleteOne(ProductId productId);

}

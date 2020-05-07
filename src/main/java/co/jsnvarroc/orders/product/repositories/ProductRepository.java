package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.product.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    Product insertOne(ProductOperationRequest productOperationRequest);
    ProductOperation findById(ProductId productId);
    List<Product> findAll();
    ProductOperation updateOne(ProductId productId, ProductOperationRequest productOperationRequest);
    ProductOperation deleteOne(ProductId productId);

}

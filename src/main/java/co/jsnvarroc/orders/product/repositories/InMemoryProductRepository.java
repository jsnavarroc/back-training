package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.product.domain.Product;
import co.jsnvarroc.orders.product.domain.ProductId;
import co.jsnvarroc.orders.product.domain.ProductOperation;
import co.jsnvarroc.orders.product.domain.ProductOperationRequest;

import java.util.List;

public class InMemoryProductRepository implements  ProductRepository {
    @Override
    public Product insertOne(ProductOperationRequest productOperationRequest) {
        return null;
    }

    @Override
    public ProductOperation findById(ProductId productId) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public ProductOperation updateOne(ProductId productId, ProductOperationRequest productOperationRequest) {
        return null;
    }

    @Override
    public ProductOperation deleteOne(ProductId productId) {
        return null;
    }
}

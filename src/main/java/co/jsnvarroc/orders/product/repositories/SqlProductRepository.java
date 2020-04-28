package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.product.domain.Product;
import co.jsnvarroc.orders.product.domain.ProductId;
import co.jsnvarroc.orders.product.domain.ProductOperationRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class SqlProductRepository implements  ProductRepository{
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    public SqlProductRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Product insertOne(ProductOperationRequest productOperationRequest) {
        System.out.println(">>>>"+productOperationRequest);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", productOperationRequest.getName().getValue());
        parameters.put("DESCRIPTION", productOperationRequest.getDescription().getValue());
        parameters.put("BASE_PRICE", productOperationRequest.getBasePrice().getValue());
        parameters.put("TAX_RATE", productOperationRequest.getTaxRate().getValue());
        parameters.put("PRODUCT_STATUS", productOperationRequest.getProductStatusEnum());
        parameters.put("INVENTORY_QUANTITY", productOperationRequest.getInventoryQuantity().getValue());
        //Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        System.out.println(parameters);
        ProductId productId = ProductId.of((long) 2);
        Product product = Product.from(
                productId,
                productOperationRequest.getName(),
                productOperationRequest.getDescription(),
                productOperationRequest.getBasePrice(),
                productOperationRequest.getTaxRate(),
                productOperationRequest.getInventoryQuantity(),
                productOperationRequest.getProductStatusEnum()
        );
        return product;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Product> updateOne(ProductId productId, ProductOperationRequest productOperationRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductOperationRequest> deleteOne(ProductId productId) {
        return Optional.empty();
    }
}

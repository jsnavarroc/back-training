package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.product.domain.*;
import co.jsnvarroc.orders.product.exceptions.ProductDoesNotExists;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SqlProductRepository implements  ProductRepository{
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    public SqlProductRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Product> rowMapper = (resultSet, i) -> {
        ProductId productId = ProductId.of(Long.valueOf(resultSet.getString("ID")));
        Name name = Name.of(resultSet.getString("NAME"));
        Description description = Description.of(resultSet.getString("DESCRIPTION"));
        BasePrice basePrice = BasePrice.of(resultSet.getBigDecimal("BASE_PRICE"));
        TaxRate taxRate = TaxRate.of(resultSet.getBigDecimal("TAX_RATE"));
        ProductStatusEnum productOperationEnum = ProductStatusEnum.valueOf(resultSet.getString("PRODUCT_STATUS"));
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(Integer.valueOf(resultSet.getString("INVENTORY_QUANTITY")));
        Product product = Product.from(productId,name,description,basePrice,taxRate, inventoryQuantity, productOperationEnum);
        return product;
    };


    @Override
    public Product insertOne(ProductOperationRequest productOperationRequest) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", productOperationRequest.getName().getValue());
        parameters.put("DESCRIPTION", productOperationRequest.getDescription().getValue());
        parameters.put("BASE_PRICE", productOperationRequest.getBasePrice().getValue());
        parameters.put("TAX_RATE", productOperationRequest.getTaxRate().getValue());
        parameters.put("PRODUCT_STATUS", productOperationRequest.getProductStatusEnum());
        parameters.put("INVENTORY_QUANTITY", productOperationRequest.getInventoryQuantity().getValue());
        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        ProductId productId = ProductId.of((Long) number);
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
    public ProductOperation findById(ProductId productId) {

        String SQL = "SELECT * FROM PRODUCTS WHERE ID = ?";
        Object[] objects = {productId.getValue()};
        try {
            Product product = jdbcTemplate.queryForObject(SQL, objects,rowMapper);
            return ProductOperationSuccess.of(product);
        }catch (EmptyResultDataAccessException e){
            return ProductOperationFailure.of(ProductDoesNotExists.of(productId));
        }
    }

    @Override
    public List<Product> findAll() {
        String SQL = "SELECT * FROM PRODUCTS";
        List<Product> products= jdbcTemplate.query(SQL, rowMapper);
        return products;
    }

    @Override
    public ProductOperation updateOne(ProductId productId, ProductOperationRequest productOperationRequest) {
        String SQL = "UPDATE PRODUCTS SET NAME = ?, DESCRIPTION = ?, BASE_PRICE= ?, TAX_RATE = ?, PRODUCT_STATUS = ?, INVENTORY_QUANTITY = ? WHERE ID = ?";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productOperationRequest.getName().getValue());
            ps.setString(2, productOperationRequest.getDescription().getValue());
            ps.setBigDecimal(3, productOperationRequest.getBasePrice().getValue());
            ps.setBigDecimal(4, productOperationRequest.getTaxRate().getValue());
            ps.setString(5, productOperationRequest.getProductStatusEnum().toString());
            ps.setInt(6, productOperationRequest.getInventoryQuantity().getValue());
            ps.setLong(7, productId.getValue());
            return ps;
        };
        int Update = jdbcTemplate.update(psc,keyHolder);
        if(Update == 1){
            Product product = Product.from(
                    productId,
                    productOperationRequest.getName(),
                    productOperationRequest.getDescription(),
                    productOperationRequest.getBasePrice(),
                    productOperationRequest.getTaxRate(),
                    productOperationRequest.getInventoryQuantity(),
                    productOperationRequest.getProductStatusEnum()
            );
            return ProductOperationSuccess.of(product);
        }else {
            return ProductOperationFailure.of(ProductDoesNotExists.of(productId));
        }
    }

    @Override
    public ProductOperation deleteOne(ProductId productId) {
        ProductOperation productOperation = findById(productId);
        String SQL = "DELETE FROM PRODUCTS WHERE ID = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, productId.getValue());
            return ps;
        };
        int Update = jdbcTemplate.update(psc,keyHolder);
        if(Update == 1){
            return productOperation;
        }else {
            return productOperation;
        }

    }
}

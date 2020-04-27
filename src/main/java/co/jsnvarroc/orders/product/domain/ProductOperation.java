package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.product.exceptions.ProductException;

public interface ProductOperation {
    Product value();
    String failure();
    Boolean isValid();
}

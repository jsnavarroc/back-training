package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.product.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationFailure implements ProductOperation {
    ProductException exception;

    @Override
    public Product value() {
        return null;
    }

    @Override
    public String failure() {
        return exception.getMessage();
    }

    @Override
    public Boolean isValid() {
        return false;
    }
}

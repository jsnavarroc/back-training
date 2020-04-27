package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.product.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationSuccess implements ProductOperation {
    Product value;

    @Override
    public Product value() {
        return value;
    }

    @Override
    public String failure() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return true;
    }
}

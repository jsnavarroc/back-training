package co.jsnvarroc.orders.product.exceptions;

import co.jsnvarroc.orders.product.domain.Name;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists  extends  ProductException{
    Name name;

    public ProductDoesNotExists(Name name) {
        super(String.format("Product %s not found.", name.getValue()));
        this.name = name;
    }
}

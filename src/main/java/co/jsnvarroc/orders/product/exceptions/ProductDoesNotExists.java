package co.jsnvarroc.orders.product.exceptions;

import co.jsnvarroc.orders.product.domain.Name;
import co.jsnvarroc.orders.product.domain.ProductId;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists  extends  ProductException{
    ProductId productId;

    public ProductDoesNotExists(ProductId productId) {
        super(String.format("Product %s not found.", productId.getValue()));
        this.productId = productId ;
    }
}

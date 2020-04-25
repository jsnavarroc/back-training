package co.jsnvarroc.orders.product.domain;


import co.jsnvarroc.orders.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductId {
    Long value;

    public ProductId(Long value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value>1L);
        this.value = value;
    }
}

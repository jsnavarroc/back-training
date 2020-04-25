package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class InventoryQuantity {
    Integer value;

    public InventoryQuantity(Integer value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value>=0);
        this.value = value;
    }
}

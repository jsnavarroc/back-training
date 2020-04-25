package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class Description {
    String value;

    public Description(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.length()> 2 &&  value.length() <= 280);
        this.value = value;
    }
}

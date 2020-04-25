package co.jsnvarroc.orders.product.domain;

import co.jsnvarroc.orders.common.Preconditions;
import co.jsnvarroc.orders.configuration.serialization.StringSerializable;
import lombok.Value;

@Value(staticConstructor = "of")
public class Name implements StringSerializable {
    String value;

    public Name(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.length()> 2 && value.length()<=100);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}

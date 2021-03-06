package co.jsnvarroc.orders.product.domain;


import co.jsnvarroc.orders.common.Preconditions;
import co.jsnvarroc.orders.configuration.serialization.BigDecimalSerializable;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class BasePrice implements BigDecimalSerializable {
    BigDecimal value;

    public BasePrice(BigDecimal value) {
        Preconditions.checkNotNull(value);
        boolean condition =  value.compareTo(BigDecimal.ZERO) >= 0;
        Preconditions.checkArgument(condition);
        this.value = value;
    }

    @Override
    public BigDecimal valueOf(){
        return value;
    }
}

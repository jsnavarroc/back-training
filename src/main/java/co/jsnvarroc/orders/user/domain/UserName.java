package co.jsnvarroc.orders.user.domain;

import co.jsnvarroc.orders.common.Preconditions;
import co.jsnvarroc.orders.configuration.serialization.StringSerializable;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class UserName implements StringSerializable {

    String value;


    private UserName(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNotBlank(value));
        Preconditions.checkArgument(value.length() >= 6 );
        this.value = value;
    }
    
    

    @Override
    public String valueOf() {
        return value;
    }
}


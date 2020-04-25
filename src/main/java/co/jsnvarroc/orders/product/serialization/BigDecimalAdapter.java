package co.jsnvarroc.orders.product.serialization;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

public class BigDecimalAdapter <T extends BigDecimalSerializable> implements GsonAdapterBigDecimal<T> {
    private final Function<BigDecimal, T> factory;

    public BigDecimalAdapter(Function<BigDecimal, T> factory) {
        this.factory = factory;
    }

    @Override
    public T deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BigDecimal value = jsonElement.getAsBigDecimal();
        return factory.apply(value);
    }

    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
       BigDecimal value = src.valueOf();
       return new JsonPrimitive(value);
    }
}

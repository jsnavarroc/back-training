package co.jsnvarroc.orders.product.serialization;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.math.BigDecimal;


public interface GsonAdapterBigDecimal<T> extends JsonDeserializer<T>, JsonSerializer<T> {
    public  static <T> BigDecimal toBigDecimal (T object) {
        return (BigDecimal) object;
    }
}

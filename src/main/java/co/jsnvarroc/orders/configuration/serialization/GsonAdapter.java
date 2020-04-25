package co.jsnvarroc.orders.configuration.serialization;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface GsonAdapter<T> extends JsonDeserializer<T>, JsonSerializer<T> {
    public  static <T> String toString (T object) {
        return object.toString();
    }
}

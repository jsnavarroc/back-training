package co.jsnvarroc.orders.product.serialization;

import co.jsnvarroc.orders.product.domain.ProductId;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ProductIdAdpter implements JsonDeserializer <ProductId>, JsonSerializer<ProductId> {

    @Override
    public ProductId deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Long value = jsonElement.getAsLong();
        return ProductId.of(value);
    }

    @Override
    public JsonElement serialize(ProductId productId, Type typeOfSrc, JsonSerializationContext context) {
        Long value = productId.getValue();
        return new JsonPrimitive(value);
    }
}
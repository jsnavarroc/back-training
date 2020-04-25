package co.jsnvarroc.orders.product.serialization;

import co.jsnvarroc.orders.product.domain.InventoryQuantity;
import co.jsnvarroc.orders.product.domain.ProductId;
import com.google.gson.*;

import java.lang.reflect.Type;

public class InventoryQuantityAdapter  implements JsonDeserializer<InventoryQuantity>, JsonSerializer<InventoryQuantity> {
    @Override
    public InventoryQuantity deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Integer value = jsonElement.getAsInt();
        return InventoryQuantity.of(value);
    }

    @Override
    public JsonElement serialize(InventoryQuantity inventoryQuantity, Type typeOfSrc, JsonSerializationContext context) {
        Integer value = inventoryQuantity.getValue();
        return new JsonPrimitive(value);
    }
}

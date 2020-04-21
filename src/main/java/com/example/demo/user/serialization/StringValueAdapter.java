package com.example.demo.user.serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class StringValueAdapter<T extends StringSerializable> implements GsonAdapter<T> {
    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String value = jsonElement.getAsString();
        return null;
    }

    @Override
    public JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        String value = t.valueOf();
        return new JsonPrimitive(value);
    }
}

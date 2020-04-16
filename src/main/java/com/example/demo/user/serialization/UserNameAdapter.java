package com.example.demo.user.serialization;

import com.example.demo.user.domain.UserName;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UserNameAdapter implements JsonDeserializer<UserName>, JsonSerializer<UserName> {


    @Override
    public UserName deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(UserName userName, Type type, JsonSerializationContext jsonSerializationContext) {
        String value = userName.getValue();
        return new JsonPrimitive(value);
    }
}

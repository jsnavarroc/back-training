package co.jsnvarroc.orders.configuration;

import co.jsnvarroc.orders.product.domain.*;
import co.jsnvarroc.orders.configuration.serialization.BigDecimalAdapter;
import co.jsnvarroc.orders.product.exceptions.ProductException;
import co.jsnvarroc.orders.product.serialization.InventoryQuantityAdapter;
import co.jsnvarroc.orders.product.serialization.ProductIdAdpter;
import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.exceptions.UserException;
import co.jsnvarroc.orders.configuration.serialization.StringValueAdapter;
import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    // La idea es solo ver esta linea una sola vez.
    @Bean
    public Gson gson(){
        Function<String, Password> creator = new Function<String, Password>(){
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };
        return new GsonBuilder()
                .registerTypeAdapter(UserName.class, new StringValueAdapter<>(UserName::of))
                .registerTypeAdapter(Password.class, new StringValueAdapter<>(creator))
                .registerTypeAdapter(UserException.class, new JsonSerializer<UserException>() {
                    @Override
                    public JsonElement serialize(UserException src, Type typeOfSrc, JsonSerializationContext context) {
                        JsonObject jsonObject = new JsonObject();
                        String message = src.getMessage();
                        JsonPrimitive errorValue = new JsonPrimitive(message);
                        jsonObject.add("error", errorValue);
                        return jsonObject;
                    }
                })
                .registerTypeAdapter(Name.class, new StringValueAdapter<>(Name::of))
                .registerTypeAdapter(Description.class, new StringValueAdapter<>(Description::of))
                .registerTypeAdapter(ProductId.class, new ProductIdAdpter())
                .registerTypeAdapter(BasePrice.class, new BigDecimalAdapter<>(BasePrice::of))
                .registerTypeAdapter(TaxRate.class, new BigDecimalAdapter<>(TaxRate::of))
                .registerTypeAdapter(InventoryQuantity.class, new InventoryQuantityAdapter())
                .registerTypeAdapter(ProductException.class, new JsonSerializer<ProductException>() {
                    @Override
                    public JsonElement serialize(ProductException src, Type typeOfSrc, JsonSerializationContext context) {
                        JsonObject jsonObject = new JsonObject();
                        String message = src.getMessage();
                        JsonPrimitive errorValue = new JsonPrimitive(message);
                        jsonObject.add("error", errorValue);
                        return jsonObject;
                    }
                })
                .create();
    }
}

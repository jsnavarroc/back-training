package co.jsnvarroc.orders.product.serialization;

import co.jsnvarroc.orders.product.domain.ProductId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductIdAdpterTest {
    static Gson gson;

    @BeforeAll
    static void setUp(){
        gson = new GsonBuilder()
                .registerTypeAdapter(ProductId.class, new ProductIdAdpter())
                .create();
    }

    @Test
    @DisplayName("Deserializador del id de producto")
    void deserializeInventoryQuantity() {
        //organizar
        Long productIdLong = 22L;
        //actuar
        ProductId actual = ProductId.of(productIdLong);
        //comprueba
        ProductId expected =  gson.fromJson(String.format("\"%s\"",productIdLong), ProductId.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador del id de producto")
    void serializeInventoryQuantity() {
        //organizar
        Long productIdLong = 22L;
        ProductId productId = ProductId.of(productIdLong);
        //actuar
        String actual = gson.toJson(ProductId.of(productIdLong));

        //comprueba
        String expected = String.format("%s",productId.getValue());
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected, actual);
        assertEquals(actual, expected, message);
    }

}
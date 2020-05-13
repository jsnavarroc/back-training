package co.jsnvarroc.orders.product.serialization;

import co.jsnvarroc.orders.configuration.serialization.BigDecimalAdapter;
import co.jsnvarroc.orders.product.domain.BasePrice;
import co.jsnvarroc.orders.product.domain.InventoryQuantity;
import co.jsnvarroc.orders.product.domain.TaxRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InventoryQuantityAdapterTest {

    static Gson gson;

    @BeforeAll
    static void setUp(){
        gson = new GsonBuilder()
                .registerTypeAdapter(InventoryQuantity.class, new InventoryQuantityAdapter())
                .create();
    }

    @Test
    @DisplayName("Deserializador de la cantidad del inventario")
    void deserializeInventoryQuantity() {
        //organizar
        Integer inventoryQuantityInteger = 100;
        //actuar
        InventoryQuantity actual = InventoryQuantity.of(inventoryQuantityInteger);
        //comprueba
        InventoryQuantity expected =  gson.fromJson(String.format("\"%s\"",inventoryQuantityInteger), InventoryQuantity.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador de la cantidad del inventario")
    void serializeInventoryQuantity() {
        //organizar
        Integer inventoryQuantityInteger = 100;
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(inventoryQuantityInteger);
        //actuar
        String actual = gson.toJson(InventoryQuantity.of(inventoryQuantityInteger));

        //comprueba
        String expected = String.format("%s",inventoryQuantity.getValue());
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected, actual);
        assertEquals(actual, expected, message);
    }

}
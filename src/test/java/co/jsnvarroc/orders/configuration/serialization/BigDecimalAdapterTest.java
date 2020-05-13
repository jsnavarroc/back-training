package co.jsnvarroc.orders.configuration.serialization;

import co.jsnvarroc.orders.product.domain.BasePrice;
import co.jsnvarroc.orders.product.domain.Name;
import co.jsnvarroc.orders.product.domain.TaxRate;
import co.jsnvarroc.orders.user.domain.UserName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalAdapterTest {

    static Gson gson;

    @BeforeAll
    static void setUp(){
        gson = new GsonBuilder()
                .registerTypeAdapter(BasePrice.class, new BigDecimalAdapter<>(BasePrice::of))
                .registerTypeAdapter(TaxRate.class, new BigDecimalAdapter<>(TaxRate::of))
                .create();
    }

    @Test
    @DisplayName("Deserializador del precio bace")
    void deserializeBasePrice() {
        //organizar
        BigDecimal basePriceBigDecimal = BigDecimal.valueOf(60.01);
        //actuar
        BasePrice actual = BasePrice.of(basePriceBigDecimal);
        //comprueba
        BasePrice expected =  gson.fromJson(String.format("\"%s\"",basePriceBigDecimal), BasePrice.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador del precio bace")
    void serializeBasePrice() {
        //organizar
        BigDecimal basePriceBigDecimal = BigDecimal.valueOf(60.01);
        BasePrice basePrice = BasePrice.of(basePriceBigDecimal);
        //actuar
        String actual = gson.toJson(BasePrice.of(basePriceBigDecimal));

        //comprueba
        String expected = String.format("%s",basePrice.getValue());
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected, actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Deserializador de la tasa")
    void deserializeTaxRate() {
        //organizar
        BigDecimal taxRateBigDecimal = BigDecimal.valueOf(0.01);
        //actuar
        TaxRate actual = TaxRate.of(taxRateBigDecimal);
        //comprueba
        TaxRate expected =  gson.fromJson(String.format("\"%s\"",taxRateBigDecimal), TaxRate.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador de la tasa")
    void serializeTaxRate() {
        //organizar
        BigDecimal taxRateBigDecimal = BigDecimal.valueOf(0.01);
        TaxRate taxRateBig = TaxRate.of(taxRateBigDecimal);
        //actuar
        String actual = gson.toJson(TaxRate.of(taxRateBigDecimal));

        //comprueba
        String expected = String.format("%s",taxRateBig.getValue());
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected, actual);
        assertEquals(actual, expected, message);
    }


}
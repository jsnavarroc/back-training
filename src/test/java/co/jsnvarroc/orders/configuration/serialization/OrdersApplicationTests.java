package co.jsnvarroc.orders.configuration.serialization;

import co.jsnvarroc.orders.product.domain.Description;
import co.jsnvarroc.orders.product.domain.Name;
import co.jsnvarroc.orders.user.domain.UserName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersApplicationTests {
    static Gson gson;

    @BeforeAll
    static void setUp(){
        gson = new GsonBuilder()
                .registerTypeAdapter(UserName.class, new StringValueAdapter<>(UserName::of))
                .registerTypeAdapter(Name.class, new StringValueAdapter<>(Name::of))
                .registerTypeAdapter(Description.class, new StringValueAdapter<>(Description::of))
                .create();
    }

    @Test
    @DisplayName("Deserializador del nombre del usuario")
    void deserializeNameUser() {
        //organizar
        String userNameString = "userName123";
        //actuar
        UserName actual = UserName.of(userNameString);
        //comprueba
        UserName expected =  gson.fromJson(String.format("\"%s\"",userNameString), UserName.class);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Serializador del nombre del usuario")
    void serializeNameUser() {
        //organizar
        String userNameString = "userName123";
        UserName userName = UserName.of(userNameString);
        //actuar
        String actual = gson.toJson(UserName.of(userNameString));

        //comprueba
        String expected = String.format("\"%s\"",userName.getValue());

        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Deserializador del nombre del producto")
    void deserializeNameProduct() {
        //organizar
        String productNameString = "productName123";
        //actuar
        Name actual = Name.of(productNameString);
        //comprueba
        Name expected =  gson.fromJson(String.format("\"%s\"",productNameString), Name.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador del nombre del producto")
    void serializeNameProduct() {
        //organizar
        String productNameString = "userName123";
        Name productName = Name.of(productNameString);
        //actuar
        String actual = gson.toJson(Name.of(productNameString));

        //comprueba
        String expected = String.format("\"%s\"",productName.getValue());

        assertEquals(actual, expected);
    }
    @Test
    @DisplayName("Deserializador de la descripción del producto")
    void derializeDescriptionProduct() {
        //organizar
        String descriptionProductString = "Description6547678798";
        //actuar
        Description actual = Description.of(descriptionProductString);

        //comprueba
        Description expected =  gson.fromJson(String.format("\"%s\"",descriptionProductString), Description.class);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected.getValue(), actual);
        assertEquals(actual, expected, message);
    }

    @Test
    @DisplayName("Serializador de la descripcion del producto")
    void serializeDescriptionProduct() {
        //organizar
        String productDescriptionString = "Description123";
        Description productDescription = Description.of(productDescriptionString);
        //actuar
        String actual = gson.toJson(Description.of(productDescriptionString));

        //comprueba
        String expected = String.format("\"%s\"",productDescription.getValue());

        assertEquals(actual, expected);
    }
}

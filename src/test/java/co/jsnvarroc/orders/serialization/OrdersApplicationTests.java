package co.jsnvarroc.orders.serialization;

import co.jsnvarroc.orders.configuration.serialization.StringValueAdapter;
import co.jsnvarroc.orders.user.domain.UserAuthRequest;
import co.jsnvarroc.orders.user.domain.UserName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersApplicationTests {
    static Gson gson;

    @BeforeAll
    static void setUp(){
        gson = new GsonBuilder()
                .registerTypeAdapter(UserName.class, new StringValueAdapter<>(UserName::of))
                .create();
    }

    @Test
    void deserialize() {
        //organizar
        String userNameString = "userName123";
        //actuar
        UserName actual = UserName.of(userNameString);
        //comprueba
        UserName expected =  gson.fromJson(String.format("\"%s\"",userNameString), UserName.class);
        assertEquals(actual, expected);
    }
¿
    @Test
    void serialize() {
        //organizar
        String userNameString = "userName123";
        UserName userName = UserName.of(userNameString);
        //actuar
        String actual = gson.toJson(UserName.of(userNameString));

        //comprueba
        String expected = String.format("\"%s\"",userName.getValue());

        assertEquals(actual, expected);
    }
}

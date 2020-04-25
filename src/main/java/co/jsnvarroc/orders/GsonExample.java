package co.jsnvarroc.orders;

import co.jsnvarroc.orders.user.domain.UserAuthRequest;
import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.serialization.UserNameAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

    public static void main(String[] args) {
        // La idea es solo ver esta linea una sola vez.
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UserName.class, new UserNameAdapter())
                .create();
        UserName userName = UserName.of("test-username");
        String password = "password...";
        UserAuthRequest request = UserAuthRequest.from(
                userName,
                password
        );
        // Se deserealiza para ser leido
        System.out.println(gson.toJson(request));
        System.out.println(gson.fromJson("{\"username\":\"test-username\",\"password\":\"password...\"}", UserAuthRequest.class));
    }
}

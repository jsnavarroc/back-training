package co.jsnvarroc.orders.user.controlers;

import co.jsnvarroc.orders.product.domain.Product;
import co.jsnvarroc.orders.product.repositories.ProductRepository;
import co.jsnvarroc.orders.user.domain.CreateUserRequest;
import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.repositories.InMemoryUserRepository;
import co.jsnvarroc.orders.user.repositories.UserRepository;
import co.jsnvarroc.orders.user.services.UserServices;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerSystemTest {

    @org.springframework.boot.test.context.TestConfiguration
    static class TestConfiguration {
        @Bean
        public UserRepository userRepository(){
            return new InMemoryUserRepository();
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServices services;

    @Autowired
    private Gson gson;

    @Test
    void createAndFindUser() throws Exception {
        UserName userName = UserName.of("UserName123");
        Password password = Password.of("Password1234");
        CreateUserRequest  createUserRequest = CreateUserRequest.of(
                userName,
                password
        );


        String content = this.gson.toJson(createUserRequest);
        String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", userName.getValue(), password.getValue());
        System.out.println(">>>"+ userName + ">>>" + password + "json>>"+ json );
        //String json = "{\"username\":\"UserName123\", \"password\":\"Password1234\"}";
        mockMvc.perform(
                post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(status().isOk())
         .andDo(mvcResult -> {
            MockHttpServletResponse response = mvcResult.getResponse();
            String responseJson = response.getContentAsString();
            System.out.println(response);
        });

        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk());

    }
}

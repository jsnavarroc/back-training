package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.user.domain.CreateUserRequest;
import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserName;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductControllerSystemTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    void createAndFindUser() throws Exception {
        UserName userName = UserName.of("UserName123");
        CreateUserRequest createUserRequest = CreateUserRequest.of(
                userName,
                Password.of("Password1234")
        );


        String username = "Username-1234";
        String password = "Password-1234";
        String content = this.gson.toJson(createUserRequest);
        String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
        String createdJson = String.format("{\"value\":{\"userName\":\"%s\",\"password\":\"%s\",\"id\":1}}", username, password);
        String findJson = String.format("{\"userName\":\"%s\",\"password\":\"%s\",\"id\":1}", username, password);




        mockMvc.perform(
                post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isOk())
                .andExpect(content().json(createdJson))
                .andDo(mvcResult -> {
                    MockHttpServletResponse response = mvcResult.getResponse();
                    String responseJson = response.getContentAsString();
                    System.out.println(responseJson);
                });

        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(findJson))
                .andDo(mvcResult -> {
                    MockHttpServletResponse response = mvcResult.getResponse();
                    String responseJson = response.getContentAsString();
                    System.out.println(responseJson);
                });

    }

}
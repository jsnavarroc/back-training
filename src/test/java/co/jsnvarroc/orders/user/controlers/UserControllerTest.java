package co.jsnvarroc.orders.user.controlers;

import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserCreated;
import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.services.UserServices;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest()
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    UserServices userServices;

    @Test
    void createUser() {
    }

    @Test
    void findUserEmpty() throws Exception {
        //organizar
        when(userServices.findById(anyLong()))
                .thenReturn(Optional.empty());
        //actuar
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/user/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    void findUser() throws Exception {
        // organizar....
        UserCreated userCreated = UserCreated.of(
                UserName.of("Username123"),
                Password.of("Password1234"),
                1L
        );
        String userJson = this.gson.toJson(userCreated);
        when(userServices.findById(anyLong()))
                .thenReturn(Optional.of(userCreated));
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/user/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(userJson));
    }
}
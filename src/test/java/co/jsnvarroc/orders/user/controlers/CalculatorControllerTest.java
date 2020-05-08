package co.jsnvarroc.orders.user.controlers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    CalculatorController calculatorController;

    @Test
    @DisplayName("Controller exists")
    public void contextLoad() throws Exception{
        assertThat(calculatorController, is(notNullValue()));
    }

    @Test
    @DisplayName("Controller returns respons in path /api/v1/calculator")
    void setCalculatorWorks() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator");
        this.mockMvc.perform(requestBuilder)
        .andExpect(status().isOk());

    }
}
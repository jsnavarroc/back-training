package co.jsnvarroc.orders.user.controlers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class CalculatorControllerTest {

    @Autowired
    CalculatorController calculatorController;

    @Test
    @DisplayName("Controller exists")
    public void contextLoad() throws Exception{
        assertThat(calculatorController, is(notNullValue()));
    }
}
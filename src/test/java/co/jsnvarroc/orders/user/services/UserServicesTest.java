package co.jsnvarroc.orders.user.services;

import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserCreated;
import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.domain.UserOperation;
import co.jsnvarroc.orders.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServicesTest {

    /* 3. Establecer la instacia de UserServices para ser retornada*/
    @Autowired
    UserServices userServices;

    /*4. Establecemos un Mock Bean*/
    @MockBean
    UserRepository repository;


    @Test
    void userCreated() {
        /*Organizar*/
        /*5. Establecer un operador de comparación, con el metodo isA, crea un nombree de usuario con un parametro primitivo */
        UserName userNameMock = ArgumentMatchers.isA(UserName.class);
        /* Creamos una instancia que intente serializar*/
        UserName userName = UserName.of("UserName123");
        //UserName userName2 = UserName.of("Johan");
        Password password = Password.of("Password1234");
        UserCreated userCreated = UserCreated.of(
                userName,
                password,
                1L
        );
        //Esto ocurre cuando se quiere comprobar que que el metodo finByUserName retorna el objeto Optional<UserCreated>
        when(repository.findByUserName(userNameMock))
                .thenReturn(Optional.of(userCreated));

        //Actuar
        UserOperation userOperation = this.userServices.userCreated(userName,password);

        //Assert
        // assertAll, es un metodo que recive varias acersiones la cual establece que todas pasen para que cumpla.
        assertAll(
            () -> assertFalse(userOperation.isValid(), "Un usuario creado no retorna error al intentar crearlo de nuevo "),
            () -> {
                // Aqui se valida que el repositorio le este llegando ese UserName al repositorio que ese pone en el when.
                Mockito.verify(this.repository, times(1)).findByUserName(userName);
            }
        );


    }
}
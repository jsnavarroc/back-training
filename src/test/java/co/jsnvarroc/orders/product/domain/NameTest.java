package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {


    @Test
    @DisplayName("No debería crear nombre para casos inválidos")
    void isShouldNotPass() {
        String name1 = null;
        String name2 = "";
        String name3 = "a";

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Name.of(name1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Name.of(name2)),
                () -> assertThrows(IllegalArgumentException.class, () -> Name.of(name3)));
    }

    @TestFactory
    @DisplayName("Deberia crear nombre de producto validos")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of("Nombre.!1", "Nombre@2", "Nomabre Caracol 3", "Nombre-A", "a-a")
                .map(name -> {
                    String testName = String.format("debería ser valido para este nombre: %s", name);
                    Executable executable = () -> {
                        // organizar

                        // actuar
                        ThrowingSupplier<Name> productIdThrowingSupplier = () -> Name.of(name);
                        // comprobar
                        assertAll(
                                () -> assertDoesNotThrow(productIdThrowingSupplier),
                                () -> assertNotNull(productIdThrowingSupplier.get())
                        );
                    };
                    return DynamicTest.dynamicTest(testName, executable);
                });
    }

    @Test
    @DisplayName("valueOf retorna el mismo valor ingresado para el nombre del producto")
    void valueOfSameValue() {
        //arrange
        String name = "Nombre De Prueba";
        Name nameInstance = Name.of(name);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", name, nameInstance.getValue());
        //assertions
        assertEquals(name, nameInstance.getValue(), message);
    }


}
package co.jsnvarroc.orders;

import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Streams {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);


        List<Integer> stream =
                integers.stream()      //generacion
                        .filter(value -> value % 2 != 0) //Transformacion de filtro
                        .peek(value -> System.out.printf("filter: %s %n",value))
                        .map(value -> value * 2)
                        .collect(Collectors.toList()); //recolector
        System.out.println(stream);

         integers.stream()      //generacion
                .filter(value -> value % 2 != 0) //Transformacion de filtro
                .forEach(value -> {
                    System.out.println(value);
                });

         List<Person> people = Arrays.asList(
                 new Person("Luis", 30),
                 new Person("Andrés", 28),
                 new Person("Juan", 18),
                 new Person("Mateo", 21)
         );

         Function <Person, Boolean> isOlderThan21 = person -> person.getAge() >21;
         Map<Boolean, List<Person>> collerction = people.stream().collect(Collectors.groupingBy(isOlderThan21));
        System.out.println(collerction);
    }

    @Value
    public  static class Person {
        private final String name;
        private final Integer age;
    }
}

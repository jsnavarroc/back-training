package co.jsnvarroc.orders;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.minBy;

public class Pizzas {
    public static void main(String[] args) {
        List<Pizza> pizzaList = Arrays.asList(
                new Pizza("Básica", Size.SMALL, 600),
                new Pizza("Familiar", Size.LARGE, 1800),
                new Pizza("Vegetariana", Size.LARGE, 860),
                new Pizza("Solo queso", Size.MEDIUM, 1000),
                new Pizza("Hawaiana", Size.SMALL, 1200),
                new Pizza("Extra carnes", Size.LARGE, 2100),
                new Pizza("Pollo", Size.SMALL, 900),
                new Pizza("Pollo + tocineta", Size.MEDIUM, 1500),
                new Pizza("Pollo + Jamon", Size.MEDIUM, 1300)
        );

        List<Pizza> pizzaListEmpty = Arrays.asList(      );
        /*
         * 1. Obtener todas las pizzas de tamaño "MEDIUM"
         */
        Predicate<Pizza> predicateSize = (Pizza pizza ) ->  pizza.size.equals(Size.MEDIUM);

        List<Pizza> pizzasMedium = pizzaList.stream()
                .filter(pizza -> predicateSize.test(pizza))
                .collect(Collectors.toList());
                System.out.println("Size>>"+pizzasMedium);
        /*
         * 2. Obtener todas las pizzas que las calorias esten entre 700 y 1500
         */
        Predicate<Pizza> predicateRange = (Pizza pizza ) ->  pizza.getCalories()>=700 && pizza.getCalories()<=1500;
        List<Pizza> pizzasCaloriesRange = pizzaList.stream()
                .filter(pizza -> predicateRange.test(pizza))
                .collect(Collectors.toList());
                System.out.println("Calories Range>>" + pizzasCaloriesRange);
        /*
         * 3. Obtener las 3 pizzas con más calorias
         */
        List<Pizza> pizzasCaloriesMore= pizzaList.stream()
                .filter(pizza -> pizza.getCalories()>=700 && pizza.getCalories()<=1500)
                .collect(Collectors.toList());
        System.out.println("Calories Range>>" + pizzasCaloriesMore);

        /*
         * 4. Obtener las 2 pizzas con menos calorias
         */

        List<Pizza> pizzasSorted = pizzaList.stream()
                                  .sorted((o1, o2) -> o1.getCalories().compareTo(o2.getCalories()))
                                  .collect(Collectors.toList());




        Comparator<Pizza> comparator = Comparator.comparingInt(Pizza::getCalories);
        Optional<Pizza> firstPizzaMin = pizzasSorted.stream().collect(minBy(comparator));


        if(firstPizzaMin.isPresent()){
            System.out.println("Primera pizza con menos calorias>>"+ firstPizzaMin.get());
            System.out.println("Segunda pizza con menos calorias>>"+ pizzasSorted.get(1));

        }else {
            System.out.println("No se contro datos");
        }



        List<Pizza> twoFirst = pizzaListEmpty.stream().limit(2)
                              .peek(value -> System.out.printf("limit: %s %n",value)).collect(Collectors.toList());


        /*Optional<Pizza> last = pizzasSorted.stream().reduce((first, second) -> second);
        System.out.println("Primera pizza con menos last>>"+ last);*/


        /*
         * 5. Del numeral 2 obtener las 2 pizzas con mas calorias
         */
        Optional<Pizza> lastPizzaMin = pizzasSorted.stream().reduce((first, last) -> last);

        if(lastPizzaMin.isPresent()){
            System.out.println("Primera pizza con mas calorias>>"+ lastPizzaMin.get());
            System.out.println("Segunda pizza con mas calorias>>"+ pizzasSorted.get(pizzasSorted.size()-2));
        }else {
            System.out.println("No se contro datos");
        }



        /*
         * 6. Agrupar las pizzas por tamaño
         */
            Map<Size, List<Pizza>> groupBySize=
                    pizzasSorted.stream().collect(Collectors.groupingBy(Pizza::getSize));
            System.out.println(groupBySize);

        /*
         * 7. Agrupar las pizzas por los siguientes grupos:
         * de 0 a 1000 calorias
         * de 1001 a 2000 calorias
         * de 2001 a 3000 calorias
         */

        Predicate<Pizza> predicate1 = (Pizza pizza ) ->  pizza.getCalories() <= 1000;
        Predicate<Pizza> predicate2 = (Pizza pizza ) ->  pizza.getCalories()>=1001 && pizza.getCalories()<=2000;
        Predicate<Pizza> predicate3 = (Pizza pizza ) ->  pizza.getCalories()>=2001 && pizza.getCalories()<=3000;
        Function <Pizza, String> funtionPizza = pizza -> {
            if(predicate1.test(pizza)){
                return "1000";
            }else{

                if(predicate2.test(pizza)){
                    return "1001 a 2000";
                }else{
                    if(predicate3.test(pizza)){
                        return "2001 a 3000";
                    }else{
                        return "No aplica";
                    }
                }
            }
        };
        Map<String, List<Pizza>> collerction = pizzasSorted.stream()
                .collect(Collectors.groupingBy(funtionPizza));
        System.out.println(collerction);


    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    public static class Pizza {
        private final String name;
        private final Size size;
        private final Integer calories;

        public Pizza(String name, Size size, Integer calories) {
            this.name = name;
            this.size = size;
            this.calories = calories;
        }

        public Size getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public Integer getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return String.format("Pizza{%s, %s, %s}", name, size, calories);
        }
    }
}



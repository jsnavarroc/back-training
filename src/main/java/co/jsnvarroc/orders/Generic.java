package co.jsnvarroc.orders;

import co.jsnvarroc.orders.user.domain.Password;

import java.util.function.Function;

public class Generic {

    public Password creator(String value, Function<String, Password> creator){
        return creator.apply(value);
    }


    public static void main(String[] args) {
        Function<String, Password> creator = new Function<String, Password>(){
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };


        Password password = creator.apply("Password");

        System.out.println(password);
    }
}

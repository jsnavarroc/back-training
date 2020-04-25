package co.jsnvarroc.orders.user.domain;

public interface UserOperation {
    UserCreated value();
    String errorMessage();

    Boolean isValid();
}

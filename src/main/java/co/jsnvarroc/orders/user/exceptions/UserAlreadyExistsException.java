package co.jsnvarroc.orders.user.exceptions;

import co.jsnvarroc.orders.user.domain.UserName;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class UserAlreadyExistsException extends UserException {
    UserName userName;

    private UserAlreadyExistsException(UserName userName) {
        super(String.format("User %s already exists", userName.getValue()));
        this.userName = userName;
    }
}


package co.jsnvarroc.orders.user.domain;

import co.jsnvarroc.orders.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "from")
public class UserAuthRequest {
    UserName username;
    String password;

    public UserAuthRequest(UserName username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        this.username = username;
        this.password = password;
    }
}

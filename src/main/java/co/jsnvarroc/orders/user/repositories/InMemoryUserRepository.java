package co.jsnvarroc.orders.user.repositories;

import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserCreated;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryUserRepository  implements UserRepository{
    private final Map<Long, UserCreated> state = new HashMap<>();

    @Override
    public UserCreated createOne(UserName userName, Password password) {
        Long id = state.size() +1L;
        UserCreated userCreated = UserCreated.of(userName, password, id);
        state.put(id, userCreated);
        return userCreated;
    }

    @Override
    public Optional<UserCreated> findById(Long id) {
        return Optional.ofNullable(state.get(id));
    }

    @Override
    public Optional<UserCreated> findByUserName(UserName userName) {
        return Optional.empty();
    }
}

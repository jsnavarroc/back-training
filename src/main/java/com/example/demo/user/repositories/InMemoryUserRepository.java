package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;

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
}

package com.example.demo.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;

import java.util.HashMap;
import java.util.Map;

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
    public UserCreated findById(Long id) {
        return state.get(id);
    }
}

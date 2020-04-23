package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("in-memory")
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

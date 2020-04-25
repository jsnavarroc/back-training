package co.jsnvarroc.orders.user.repositories;

import co.jsnvarroc.orders.user.domain.UserName;
import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserCreated;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    UserCreated createOne(UserName userName, Password password);
    Optional<UserCreated> findById(Long id);
    Optional<UserCreated> findByUserName(UserName userName);
}
